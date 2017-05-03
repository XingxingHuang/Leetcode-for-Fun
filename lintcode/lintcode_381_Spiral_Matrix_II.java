// http://www.lintcode.com/en/problem/spiral-matrix-ii/
// 循环即可，注意循环边界
//      -----------|
//    -  1    2  ...  n-1    |
//    |  1    2  ...  n-1    |
//    |  ..   2  ...  ...    -
//    |  n-1  2  ...  n-1
//          |-----------
// http://www.jiuzhang.com/solutions/spiral-matrix-ii/
public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        if (n < 0) {
            return null;
        }
        int[][] res = new int[n][n];
        int i = 0;
        int j = n - 1;
        int val = 1;
        while (i <= j) {
            if (i == j) {
                res[i][j] = val++;
                break;
            }
            for (int k = i; k < j; k++) {
                res[i][k] = val++;
            }
            for (int k = i; k < j; k++) {
                res[k][j] = val++;
            }
            for (int k = j; k > i; k--) {
                res[j][k] = val++;
            }
            for (int k = j; k > i; k--) {
                res[k][i] = val++;
            }
            i++;
            j--;
         }
         return res;
    }
}