// 11.19
// 多重循环，从外环依次移动
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return;
        int m = matrix.length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < m - 2 * i - 1; j++) {
                int x = i;
                int y = i + j;
                int tmp = matrix[x][y];
                tmp = move(matrix, tmp, y, m - 1 - x); 
                tmp = move(matrix, tmp, m - 1 - x, m - 1 - y);
                tmp = move(matrix, tmp, m - 1- y, x);
                matrix[x][y] = tmp;
            }
        }
    }
    private int move(int[][] matrix, int val, int x, int y) {
        // System.out.println(x +  "  " + y);
        int tmp = matrix[x][y];
        matrix[x][y] = val;
        return tmp;
    }
}


// best solution, transpose then flip
public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}