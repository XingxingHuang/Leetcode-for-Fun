//http://www.lintcode.com/en/problem/stone-game/

// 自底向上思考，记忆化搜索可以转化成动态规划！ 
// 但是状态转移非常麻烦，需要很注意，小心
public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        } 
        // initialization
        int n = A.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // prepare
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i][i] = A[i - 1];
            for (int j = i + 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j - 1];
            }
        }
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n; i++) {
                int j = i + len;
                if (j > n) continue;
                for (int k = 0; k < len; k++) {
                    // 状态转移：
                    //      注意需要加上sum。
                    //      注意这里状态转移的时候需要计算不同k下的最小值。
                    dp[i][j] = Math.min(dp[i][i + k] + dp[i + k + 1][j] + sum[i][j],
                                        dp[i][j]);
                }
            }
        }
        // for (int i = 1; i <= n; i++) {
        //     for (int j = i + 1; j <= n; j++) {
        //         System.out.println(i+" "+j+" "+dp[i][j]+" "+" ");
        //     }
        // }        
        return dp[1][n];
    }
}

// 记忆化搜索
public class Solution {
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // initialization and prepare
        int n = A.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        
        int[][] dp = new int[n][n];
        int[][] flag = new int[n][n];
        
        // search
        return search(0, n - 1, A, dp, flag, sum);
    }
    
    private int search(int l, int r, int[] A, int[][] dp, int[][] flag, int[] sum) {
        if (flag[l][r] == 1 || l == r) {
            return dp[l][r];
        }
        dp[l][r] = Integer.MAX_VALUE;
        int sumlr = sum[r + 1] - sum[l];
        for (int k = 0; k < r - l; k++) {
            dp[l][r] = Math.min(dp[l][r], 
                        search(l, l + k, A, dp, flag, sum) + 
                        search(l + k + 1, r, A, dp, flag, sum) + 
                        sumlr);
        }
        flag[l][r] = 1;
        return dp[l][r];
    }
}

// 九章算法： http://www.jiuzhang.com/solution/stone-game/
//记忆化
public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    int search(int l, int r, int[][] f, int[][] visit, int[][] sum) {
        
        if (visit[l][r] == 1 || l == r)
            return f[l][r];
        
        f[l][r] = Integer.MAX_VALUE;
        for (int k = l; k < r; k++) {
            f[l][r] = Math.min(f[l][r], 
                        search(l, k, f, visit, sum) + 
                        search(k + 1, r, f, visit, sum) + 
                        sum[l][r]); // 计算分值
        }
        visit[l][r] = 1;
        return f[l][r];
    }
    
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        
        // initialize
        int[][] f = new int[n][n];  // 记录分数
        int[][] visit = new int[n][n]; // 记录访问情况
        
        // for (int i = 0; i < n; i++) {   // 初始化得分为0
        //     f[i][i] = 0;
        // }
        
        // preparation
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }
        
        return search(0, n-1, f, visit, sum);
    }
}


// for 循环，
// 相当于用dp[i][j]的值是否为MAX_VALUE来判断是否访问过。
public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if(A.length==0) {
            return 0;
        }
        int[][] dp=new int[A.length][A.length];
        int[] sums=new int[A.length+1];
        sums[0]=0;
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<A.length;i++){
            dp[i][i]=0;
            sums[i+1]=sums[i]+A[i];
        }
        
        return search(0,A.length-1,dp,sums);
    }
    
    private int search(int start, int end, int[][] dp, int[] sums){
        if(dp[start][end]!=Integer.MAX_VALUE){
            return dp[start][end];
        }
        int min=Integer.MAX_VALUE;
        for(int k=start;k<end;k++){
            int left = search(start,k,dp,sums);
            int right = search(k+1,end,dp,sums);
            int now = sums[end+1]-sums[start];
            min=Math.min(min,left+right+now);
        }
        dp[start][end]=min;
        return min;
    }
}
