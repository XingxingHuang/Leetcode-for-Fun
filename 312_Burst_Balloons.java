/**
 * 记忆化搜索，分治，DP
 * 关键点在于如何拆分成子问题求解。不一定是直觉想到的拆分方法。拆分方法可能特别奇特。
 * 例如, 下面的例子中拆分方法几乎不可能直观想出来。
 *    Tiling Problem (easy):   http://www.geeksforgeeks.org/tiling-problem/
 *    Tri Tiling Problem (hard): https://azfar.quora.com/Tri-Tiling-Dynamic-Programming
 * 本题中，如果假设i位是最后一个burst的，那么左右两边的计算结果相互独立而不影响。
 * 因此可以通过第i位是否是最后一个burst，将问题简化为子问题通过记忆化搜索/动态规划来降低计算复杂度。
 * dp[i][j]的含义是：
 *      上轮最后burst只剩下i号气球，这一轮最后burst的j号气球，计算结果的最大值。
 *      先计算间隔为2的结果，然后递推求得间隔最大的情况，即为最终结果dp[0][m - 1]；
 * @author  Xingxing Huang  
 * @since   2017.05.03
 * @Time    O(n^3) for DP   
 * @param   int[], values.
 * @return  int, max value.
 */
public class Solution {
    public int maxCoins(int[] iNums) {
        // 建立新数组，头尾加上1
        int[] nums = new int[iNums.length + 2];
        nums[0] = 1;
        nums[nums.length - 1] = 1;
        for (int i = 0; i < iNums.length; i++) {
            nums[i + 1] = iNums[i];
        }
        
        int m = nums.length;
        int[][] dp = new int[m][m];
        // gap 表示right 和 left 的差值
        for (int gap = 2; gap < m; gap++) {
            for (int left = 0; left < m - gap; left++) {
                int right = left + gap;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], 
                        nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][m - 1];
    }
}

// 记忆化搜索的代码
// https://leetcode.com/problems/burst-balloons/#/solutions
public int maxCoins(int[] iNums) {
    int[] nums = new int[iNums.length + 2];
    int n = 1;
    for (int x : iNums) if (x > 0) nums[n++] = x;
    nums[0] = nums[n++] = 1;


    int[][] memo = new int[n][n];
    return burst(memo, nums, 0, n - 1);
}

public int burst(int[][] memo, int[] nums, int left, int right) {
    if (left + 1 == right) return 0;
    if (memo[left][right] > 0) return memo[left][right];
    int ans = 0;
    for (int i = left + 1; i < right; ++i)
        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
    memo[left][right] = ans;
    return ans;
}