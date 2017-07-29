// 使用hashset，需要额外的空间
// 常数空间的解法是利用matrix本身的第一行和第一列来记录0的信息。
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();        
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i : row) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i : col) {
            for (int j = 0; j < m; j++) {
                matrix[j][i] = 0;
            }
        }
        return;
    }
}

public class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        //boolean firstrow = false; 不需要
        boolean firstcol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) 
                firstcol = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) 
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 将列信息移动到下一行， 第一行存储了为0的列。
                if (matrix[i][j] == 0 && i + 1 < m) 
                    matrix[i + 1][j] = 0;
                // 根据该行最前面的信息，判断改行是否为0.
                if (matrix[i][0] == 0) 
                    matrix[i][j] = 0;
            }
            // 根据存储的boolean变量，判断第一列是否应该为0。
            if (firstcol) 
                matrix[i][0] = 0;
        }

//         for (int i = 0; i < rows; i++) {
//             if (matrix[i][0] == 0) col0 = 0;
//             for (int j = 1; j < cols; j++)
//                 if (matrix[i][j] == 0)
//                     matrix[i][0] = matrix[0][j] = 0;
//         }

//         for (int i = rows - 1; i >= 0; i--) {
//             for (int j = cols - 1; j >= 1; j--)
//                 if (matrix[i][0] == 0 || matrix[0][j] == 0)
//                     matrix[i][j] = 0;
//             if (col0 == 0) matrix[i][0] = 0;
//         }
    }
}