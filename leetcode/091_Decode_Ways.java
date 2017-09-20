// 2017.07.29
// attention for the initiation 
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  // attention 
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // attention 
        for (int i = 1; i < n; i++) {
            // dp[i + 1] 
            int first = Integer.valueOf(s.substring(i, i + 1));
            int last = Integer.valueOf(s.substring(i - 1, i + 1));
            if (first >= 1 && first <= 9) {
                dp[i + 1] += dp[i];
            } 
            if (last >= 10 && last <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }
}