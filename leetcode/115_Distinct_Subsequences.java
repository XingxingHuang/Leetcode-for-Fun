// 2017.08.03 XingxingHuang
// 题目的意思是检查S的子串中，有多少等于T
public class Solution {
    private int count = 0;
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) 
            return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 初始化   s = "xxx" t = ""
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        // 二维DP
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i && j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j -1 )) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
// // !!! 题目理解错误!!!题目的意思是求满足要求的S的子串的个数。要求是T为字符串的子串。
// public class Solution {
//     private int count = 0;
//     HashSet<String> set = new HashSet<>();
//     public int numDistinct(String s, String t) {
//         helper(s, t, 0, 0, "");
//         return count;
//     }
//     private void helper (String s, String t, int m, int n, String str) {
//         // stop condition
//         if (n == t.length() && m == s.length()) {
//             if (!set.contains(str)) {
//                 set.add(str);
//                 count++;
//             }
//             return;
//         } else if (m == s.length()) {
//             return;
//         }
//         // check string
//         if (n < t.length() && s.charAt(m) == t.charAt(n)) {
//             helper(s, t, m + 1, n + 1, str + s.substring(m, m + 1));
//         }
//         helper(s, t, m + 1,n, str + s.substring(m, m + 1));
//         helper(s, t, m + 1,n, str);       
//     }
// }