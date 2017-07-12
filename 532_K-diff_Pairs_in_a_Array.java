// 注意考虑k = 0 的情况
public class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1) 
                    count++;
            } else if (k > 0) {
                if (map.containsKey(key + k))
                    count++;
            }
        }
        return count;
    }
}