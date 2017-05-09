// @Author: 黄xing
// time O(log N)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (target > matrix[mid / n][mid % n]) {
                start = mid + 1;
            } else if (target < matrix[mid / n][mid % n]) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

// // @Author: 黄xing
// // 暴力求解法，适用于每行每列都是有序，但是整体不是有序的情况
// // time: O(M*N)
// public class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix.length == 0 || matrix[0].length == 0) {
//             return false;
//         }
//         int i = 0;
//         int j = matrix[0].length - 1;
//         while (i < matrix.length && j >= 0) {
//             if (matrix[i][j] > target) {
//                 j--;
//             } else if (matrix[i][j] < target) {
//                 i++;
//             } else {
//                 return true;
//             }
//         }
//         return false;
//     }
// }