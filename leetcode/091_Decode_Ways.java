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


// memorization method, TLE
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] mem = new int[s.length()];
        return helper(s, 0, mem);
    }
    private int helper(String s, int idx, int[] mem) {
        if (idx == s.length()) 
            return 1;
        // one char
        int c1 = 0;
        if (s.charAt(idx) != '0') 
            c1 = helper(s, idx + 1, mem);
        // two char
        int c2 = 0;
        if (idx + 1 < s.length() && (s.charAt(idx) == '1' || (s.charAt(idx) == '2'  && s.charAt(idx +1) - '0' <= 6))) 
            c2 = helper(s, idx + 2, mem);
        // mem
        mem[idx] = c1 + c2;
        return mem[idx];
    }
}