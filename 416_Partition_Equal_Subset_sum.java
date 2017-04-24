/**
 * 转化成背包问题求解。考虑空间压缩
 * @author  Xingxing Huang  
 * @since   2017.04.23
 * @Time    O(n)    
 * @param   int[]
 * @return  boolean
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 2D DP, 小于某一长度是否能成某和。最后返回是否有能组成sum/2的数组和。
        // 建立DP递推状态组合
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        // 初始化状态
        dp[0][0] = true;
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum / 2 + 1; j++) {
            dp[0][j] = false;
        }
        // 计算状态转移方程
        // 采用i个元素, 是否能达到j的和。那么查看i-1个元素是可行，
        // 或者i-1个元素，能否产生j - nums[i - 1]的和
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = sum / 2; j >= nums[i - 1]; j--) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        // 返回答案
        return dp[nums.length][sum / 2];
    }
}
// 这里是已经做过空间优化
public class Solution {
    public boolean canPartition(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return false;
        }
        // check the sum
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // start define, init, transition dp
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[sum / 2];
    }
}