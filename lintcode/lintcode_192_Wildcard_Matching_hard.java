// https://www.lintcode.com/en/problem/wildcard-matching/
// For detailed explanation, see https://leetcode.com/problems/wildcard-matching/#/solutions

// 九章算法结果比较繁琐 http://www.jiuzhang.com/solutions/wildcard-matching/
// Time: O(|s||p|*log|s|), Space: O(|s|)
// Time can also optimize to O(|s||p|)
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化，s为空时，只要p中出现非*元素就返回
        // 从前往后填充初始的矩阵行，理论上只有*的时候才是true，其它情况跳出。
        dp[0][0] = true;
        // // 这段代码可用，可以替换下面的代码。
        // for (int i = 0; i < n; i++) {
        //     if (p.charAt(i) != '*') 
        //         break;
        //     else 
        //         dp[0][i + 1] = true;
        // }
        for(int i = 1 ; i <= n ; i++){
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
            if(!dp[0][i])
                break;
        }        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') 
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*') 
                    // 这时候只需要[i][j + 1]]能够匹配，那么就能匹配
                    // 可以递归的看到[i 后面][j + 1]都能够匹配。
                    // 要是[j]已经匹配了，那么这里也能够匹配。
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                else 
                    dp[i + 1][j + 1] = false;
            }
        }
        return dp[m][n];
        // // 从后往前
        // dp[m][n] = true;
        // for (int i = n - 1; i >= 0; i--) {
        //     if (p.charAt(i) != '*') 
        //         break;
        //     else 
        //         dp[m][i] = true;
        // }
        // for (int i = m - 1; i >= 0; i--) {
        //     for (int j = n -1; j >= 0; j--) {
        //         if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') 
        //             dp[i][j] = dp[i + 1][j + 1];
        //         else if (p.charAt(j) == '*')
        //             dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
        //         else 
        //             dp[i][j] = false;
        //     } 
        // }
        // return dp[0][0];
    }
}