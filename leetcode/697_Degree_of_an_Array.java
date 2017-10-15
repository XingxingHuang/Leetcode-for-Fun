class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int degree = 0;
        int len = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        Map<Integer, Integer> times = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            times.put(nums[i], times.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, times.get(nums[i]));
        }
        if (degree == 1) 
            return 1;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, 1});
            } else {
                map.get(nums[i])[1]++;
                if (map.get(nums[i])[1] == degree) {
                    len = Math.min(len, i - map.get(nums[i])[0] + 1);
                }
            }
        }
        return len;
    }
}