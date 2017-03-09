// @Author Xingxing Huang
// O(n)
// Notice: error found if using matrix == []
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int count = 0;
        int lenx = 0;
        int leny = matrix[0].length - 1;
        while (lenx <= matrix.length - 1 && leny >= 0) {
            if (matrix[lenx][leny] > target) {
                leny--;
            } else if (matrix[lenx][leny] < target) {
                lenx++;
            } else {
                count++;
                lenx++;
                leny--;
            }
        }
        return count;
    }
}




// // @Author Xingxing Huang
// // O(n^2)
// // Notice: error found if using matrix == []
// public class Solution {
//     /**
//      * @param matrix: A list of lists of integers
//      * @param: A number you want to search in the matrix
//      * @return: An integer indicate the occurrence of target in the given matrix
//      */
//     public int searchMatrix(int[][] matrix, int target) {
//         // write your code here
//         if (matrix == null || matrix.length == 0) {
//             return 0;
//         }
//         int count = 0;
//         int lenx = matrix.length;
//         int leny = matrix[0].length;
//         for (int i = 0; i < lenx; i++) {
//             for (int j = 0; j < leny; j++) {
//                 if (matrix[i][j] == target) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
