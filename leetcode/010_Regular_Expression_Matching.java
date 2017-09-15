// 9.15
// '*' means Matches zero or more of the *preceding element*.
class Solution {
    public boolean isMatch(String s, String p) {
        // corner case
        if (s == null && p == null) 
            return true;
        if (s == null || p == null)
            return false;
        int m = s.length();
        int n = p.length();
        
        // init
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2])
                dp[0][i] = true;
        }

        // dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') 
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    // 'a*' considerred as ''
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.')
                        dp[i][j] = dp[i][j - 2];
                    else 
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
            }
        }
        return dp[m][n];
    }
}