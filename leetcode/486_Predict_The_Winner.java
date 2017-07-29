/**
 * 二维DP，二维坐标表示为剩余i, j时候的结果。
 * 暴力法中每次计算DP矩阵的值需要递归求解，这里只是把值存了起来。
 * @athor   Xingxing Huang  
 * @since   2017.04.16  
 * @Time    O(2^n),     
 * @param   int[]
 * @return  boolean
 */
public class Solution {
    // // 递归DP 解法
    // public boolean PredictTheWinner(int[] nums) {
    //     return helper(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    // }
    // private int helper(int[] nums, int l, int r, Integer[][] mem) {
    //     if (mem[l][r] == null) {
    //         mem[l][r] = l == r ? nums[r] : 
    //                 Math.max(nums[r] - helper(nums, l, r-1, mem), 
    //                 nums[l] - helper(nums, l+1, r, mem));
    //     }
    //     return mem[l][r];
    // }
    // DP解法
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        // dp矩阵初始化
        for (int i = 0; i < n; i++) { 
            dp[i][i] = nums[i]; 
        }
        // 状态转移计算
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        // 返回最佳值
        return dp[0][n - 1] >= 0;
    }    
}