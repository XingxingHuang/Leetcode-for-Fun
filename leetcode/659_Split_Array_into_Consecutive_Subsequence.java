// 2017.08.15  XingxingHuang
// My idea with higher time complexity
public class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Map<Integer, Integer> map1 = new HashMap<>(); // index, length of consecutive subsequence pair, only for length < 3
        Map<Integer, Integer> map2 = new HashMap<>(); // index, length of consecutive subsequence pair, for length > 3
        int idx = 0;
        
        while (idx < nums.length) {
            boolean flag_put_into_map1 = false;
            boolean flag_put_into_map2 = false;
            // put into map1
            for (int key1: map1.keySet()) {
                if (idx < nums.length && nums[key1] + map1.get(key1) == nums[idx]) {
                    flag_put_into_map1 = true;
                    map1.put(key1, map1.get(key1) + 1);
                    idx++;
                    break;
                }
            }
            // put into map2
            if (!flag_put_into_map1) {
                for (int key2: map2.keySet()) {
                    if (idx < nums.length && nums[key2] + map2.get(key2) == nums[idx]) {
                        flag_put_into_map2 = true;
                        map2.put(key2, map2.get(key2) + 1);
                        idx++;
                        break;
                    }
                }
            }
            // move key from map1 to map2 if the length of sequence is longer than 3
            Iterator<Map.Entry<Integer, Integer>> it = map1.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                Integer key = entry.getKey();
                if (map1.get(key) == 3) {
                    map2.put(key, map1.get(key));
                    it.remove();
                }
            }
            // add new to map1
            if (idx < nums.length && !flag_put_into_map1 && !flag_put_into_map2) {
                // Time Limit Exceeded if no early stop 
                for (int key1: map1.keySet()) { 
                    if (nums[key1] + map1.get(key1) < nums[idx] - 1) 
                        return false;
                }
                map1.put(idx, 1);
                idx++;
            }
        }
        return map1.isEmpty();
    }
}




// O(n) O(n)
// These two lines are used to track previous consecutive sequences next elements' values. 
// If current element can be next element of one of previous consecutive sequences, 
// it means we can append it to that sequence. 
// We don't need to worry about whether we can use this element to be a new start point of a new consecutive sequence, 
// that's because even though the current element can be a new start point of a consecutive sequence, 
// we can simply append those consecutive elements following this current element at the end of the previous consecutive sequence.

public boolean isPossible(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
    for (int i : nums) freq.put(i, freq.getOrDefault(i,0)+1);
    for (int i : nums) {
        if (freq.get(i) == 0) continue;
        else if (appendfreq.getOrDefault(i,0) > 0) {
            appendfreq.put(i, appendfreq.get(i)-1);
            appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0)+1);
        }   
        else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
            freq.put(i+1, freq.get(i+1) - 1);
            freq.put(i+2, freq.get(i+2) - 1);
            appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
        }
        else return false;
        freq.put(i, freq.get(i) - 1);
    }
    return true;
}cd