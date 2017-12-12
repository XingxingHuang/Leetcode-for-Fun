// 12.12 DP 简单
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i< nums.length; i++){
            if(i > max) 
                return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}


// 超时
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) 
            return false;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 1) {
                // 注意循环条件判断
                for (int j = 1; j <= nums[i] && i + j < nums.length; j++)
                    dp[i + j] = 1;
            }
        }
        return dp[nums.length - 1] == 1;
    }
}