// 2017.08.29 XingxingHuang
// 采用一个helper数组存储是否分析过i,j的情况，节省时间。
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) 
            return false;
        int m = s1.length();
        int n = s2.length();
        boolean[][] mem = new boolean[m + 1][n + 1];
        return dfs(s1, s2, s3, 0, 0, m, n, mem);
    }
    private boolean dfs(String s1, String s2, String s3, 
                            int i, int j, int m, int n, boolean[][] mem){
        mem[i][j] = true;
        if (i == m && j == n) 
            return true;
        boolean f1 = false;
        boolean f2 = false;
        if (i < m && !mem[i + 1][j] && s1.charAt(i) == s3.charAt(i + j)) 
            f1 = dfs(s1, s2, s3, i + 1, j, m, n, mem);
        if (!f1 && j < n && !mem[i][j + 1] && s2.charAt(j) == s3.charAt(i + j))
            f2 = dfs(s1, s2, s3, i, j + 1, m, n, mem);
        return f1 || f2;
    }
}


// // Time Limit Exceeded 
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) 
            return false;
        int m = s1.length();
        int n = s2.length();
        return dfs(s1, s2, s3, 0, 0, m, n);
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j, int m, int n){
        if (i == m && j == n) 
            return true;
        else if (i > m || j > n) 
            return false;
        boolean f1 = false;
        boolean f2 = false;
        if (i < m && s1.charAt(i) == s3.charAt(i + j)) 
            f1 = dfs(s1, s2, s3, i + 1, j, m, n);
        if (!f1 && j < n && s2.charAt(j) == s3.charAt(i + j))
            f2 = dfs(s1, s2, s3, i, j + 1, m, n);
        return f1 || f2;
    }
}


// solution 
// https://leetcode.com/problems/interleaving-string/solution/
public class Solution {
    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if (s3.charAt(k) == s1.charAt(i) && is_Interleave(s1, i + 1, s2, j, s3, k + 1, memo)
                || s3.charAt(k) == s2.charAt(j) && is_Interleave(s1, i, s2, j + 1, s3, k + 1, memo)) {
            ans = true;
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return is_Interleave(s1, 0, s2, 0, s3, 0, memo);
    }
}


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}