// http://www.lintcode.com/en/problem/backpack-ii/
// 通Backpack I思路一样，这里加入了value的值，
// 九章的代码通过了空间优化。省去了第一维部分

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + V[i - 1], dp[i][j]);
                }
            }
        }
        return dp[n][m];
        // // 这段代码不需要 
        // for (int i = m; i >= 0; i--) {
        //     if (dp[n][i] != 0) {
        //         return dp[n][i];
        //     }
        // }
        // return 0;
    }
}


// 九章答案
// http://www.jiuzhang.com/solution/backpack-ii/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[] f = new int[m+1];
        for (int i = 0; i <=m ; ++i) f[i] = 0;
        int n = A.length , i, j;
        for(i = 0; i < n; i++){
            for(j = m; j >= A[i]; j--){
                if (f[j] < f[j - A[i]] + V[i])
                    f[j] = f[j - A[i]] + V[i];
            }
        }
        return f[m];
    }
}