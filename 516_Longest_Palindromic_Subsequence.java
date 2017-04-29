/**
 * DP问题。
 * 知识点:  回文，子序列。
 * 技巧点:  回文判断 + 双指针滑动窗口
 * state:
 *      dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
 * function:
 *      dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
 *          else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
 * Initialization: 
 *      dp[i][i] = 1
 * @author  Xingxing Huang  
 * @since   2017.04.27
 * @Time    O(n^2)
 * @param   String
 * @return  int
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        char[] chars = s.toCharArray();
        // state
        int[][] dp = new int[m][m];
        // initialization
        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }
        // function
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                if (chars[j] == chars[i]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        //result
        return dp[0][m - 1];
    }
}


public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

//Top bottom recursive method with memoization
public class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    
    private int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}