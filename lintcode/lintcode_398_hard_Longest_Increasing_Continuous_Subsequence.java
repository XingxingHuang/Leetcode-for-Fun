// http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence-ii/
// 记忆化搜索，当动态规划的状态转移方程很复杂的时候，可以考虑采用记忆化搜索。
public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    int [][]dp;
    int [][]flag ;
    int n ,m;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        // corner case
        if(A.length == 0)
            return 0;
        // initialization
        n = A.length;
        m  = A[0].length;
        int ans= 0;
        dp = new int[n][m];
        flag = new int[n][m];
        
        // dp
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                dp[i][j] = search(i, j, A);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    
    // 记忆化搜索
    int search(int x, int y, int[][] A)   {
        if(flag[x][y] != 0)    
            return dp[x][y];
        
        int ans = 1; 
        int nx , ny;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(0<= nx && nx < n && 0<= ny && ny < m ) {
                if( A[x][y] > A[nx][ny]) {
                    ans = Math.max(ans,  search( nx, ny, A) + 1);
                }
            }
        }
        flag[x][y] = 1;
        dp[x][y] = ans;
        return ans;
    }
}