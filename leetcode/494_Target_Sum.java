/**
 * 
 * @author  Xingxing Huang  
 * @since   2017.04.23
 * @Time    O(2^n)  
 * @param   
 * @return  
 */
// DP 的方法，参考solution中的图解。
public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0; 
        for(int i: nums) sum+=i;
        if(s > sum || s < -sum) {
            return 0;
        }
        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;
        for(int i = 0; i < nums.length; i++){
            int[] next = new int[2 * sum + 1];
            for(int k = 0; k < 2 * sum + 1; k++){
                if(dp[k] != 0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
}
// 根据数学可以转换问题为下面的问题。
// Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //return sum < S || (S + sum) % 2 > 0 ? 0: subsetSum(nums, (S + sum) >>> 2);
        // 提前结束判断的条件
        if (sum < S || (S + sum) % 2 > 0) {  
            return 0;
        } 
        return subsetSum(nums, (S + sum) >>> 1);
    }
    public int subsetSum(int[] nums , int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int n: nums) {
            for (int i = sum; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[sum];
    }
}

// brute force method
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null){
            return 0;
        }
        return helper(nums, S, 0);
    }
    public int helper(int[] nums, int s, int i) {
        if (i == nums.length && s == 0) {
            return 1;
        } else if (i == nums.length) {
            return 0;
        }
        return helper(nums, s - nums[i], i + 1) + helper(nums, s + nums[i], i + 1);
    }
}