// 2017.08.09 XingxingHuang
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        
        int count = 0;
        int i1 = 0;
        int j1 = 0;
        int i2 = 0;
        int j2 = 0;
        boolean lo2hi = true; // lower left to upper right;
        
        while (count < m * n) {
            // System.out.println(count + " " +i1 + " " + j1 + " " + i2 + " " + j2);
            count = add(matrix, res, i1, j1, i2, j2, count, lo2hi);
            lo2hi = !lo2hi;
            j1 = i1 == (m - 1) ? (j1 + 1) : j1;
            i1 = i1 == (m - 1) ? i1 : (i1 + 1);
            i2 = j2 == (n - 1) ? (i2 + 1) : i2;
            j2 = j2 == (n - 1) ? j2 : (j2 + 1);
        }
        return res;
    }
    private int add(int[][] matrix, int[] res, int i1, int j1, int i2, int j2, int count, boolean lo2hi) {
        if (lo2hi) {
            while (i1 >= i2) {
                res[count] = matrix[i1--][j1++];
                count++;
            }
        } else {
            while (i2 <= i1) {
                res[count] = matrix[i2++][j2--];
                count++;
            }
        }
        return count;
    }
}

// https://discuss.leetcode.com/topic/77865/concise-java-solution
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        
        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];
            
            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }
        
        return result;
    }
}