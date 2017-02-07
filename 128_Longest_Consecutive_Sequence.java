public class Solution {
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (map.containsKey(n)) {continue; }
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);
            
            // keep track of the max length 
            res = Math.max(res, sum);
            
            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        return res;
    }
}

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {continue;}
            int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
            int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
            // 修正该位置和该联通区连段的数值，
            map.put(nums[i], left + right + 1);
            map.put(nums[i] - left, left + right + 1);
            map.put(nums[i] + right, left + right + 1);
            // System.out.println(map);
        } 
        for (int key: map.keySet()) {
            if (map.get(key) > result) {result = map.get(key);}
        }
        return result;
    }
}
