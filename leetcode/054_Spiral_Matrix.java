// 09.23
// 注意中间只有一个元素的情况。
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int p = m - 1;
        int q = n - 1;
        while (i <= p && j <= q) {
            for (int k = j; k <= q; k++) list.add(matrix[i][k]);
            i++;
            for (int k = i; k <= p; k++) list.add(matrix[k][q]);
            q--;
            if (i <= p) { //  attention
                for (int k = q; k >= j; k--) list.add(matrix[p][k]);
                p--;
            }
            if (j <= q) {
                for (int k = p; k >= i; k--) list.add(matrix[k][j]);
                j++;
            }
        }
        return list;
    }
}