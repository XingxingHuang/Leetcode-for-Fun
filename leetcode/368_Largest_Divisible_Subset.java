// 12.13 动态规划！！
// 如果 d[j] % d[i] = 0, 那么j位置满足条件的长度 = i位置长度 + 1， 
// 但是动态规划只能计算长度，我们需要一个反向的过程求得满足条件的元素。
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        // 正向动态规划
        int maxIdx = 0;
        int[] dp = new int[nums.length]; 
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxIdx = dp[i] > dp[maxIdx] ? i : maxIdx;
        }
        // 反向查找满足条件元素
        int maxValue = nums[maxIdx];
        int count = dp[maxIdx];
        for (int i = maxIdx; i >= 0; i--){
            if (maxValue % nums[i] == 0 && dp[i] == count){
                res.add(nums[i]);
                maxValue = nums[i];
                count--;
            }
        }
        return res;
    }
}