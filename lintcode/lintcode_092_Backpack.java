// http://www.lintcode.com/en/problem/backpack/
// dp[i][j] 代表能否用前i个物品组成价值为j的集合。
public class Solution {
    public int backPack(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n][i] == 1) {
                return i;
            }
        }
        return 0;
    }
}


// 错误：只有A.length 个物品。
// public class Solution {
//     /**
//      * @param m: An integer m denotes the size of a backpack
//      * @param A: Given n items with size A[i]
//      * @return: The maximum size
//      */
//     public int backPack(int m, int[] A) {
//         // write your code here
//         int[] dp = new int[m + 1];
//         for (int i = 0; i < A.length; i++) {
//             dp[A[i]] = 1;
//         }
//         for (int i = 0; i <= m; i++) {
//             for (int j = 0; j < A.length; j++) {
//                 if (i - A[j] >= 0 && dp[i - A[j]] == 1) {
//                     dp[i] = 1;
//                 }
//             }
//         }
//         System.out.println(Arrays.toString(dp));
//         for (int i = m; i >= 0; i--) {
//             if (dp[i] == 1) {
//                 return i;
//             }
//         }
//         return 0;
//     }
// }

// 九章答案
// http://www.jiuzhang.com/solution/backpack/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i-1] && f[i-1][j - A[i-1]]) {
                    f[i][j] = true;
                }
            } // for j
        } // for i
        
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        
        return 0;
    }
}