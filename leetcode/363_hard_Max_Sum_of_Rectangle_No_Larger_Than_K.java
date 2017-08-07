// 2017.08.04 XingxingHuang 
// brute force method. O(n^4)
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) 
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] + matrix[i][j] - sum[i][j];
                for (int x = 0; x <= i; x++) {
                    for (int y = 0; y <= j; y++) {
                        int total = sum[i + 1][j + 1] + sum[x][y] - sum[x][j + 1] - sum[i + 1][y];
                        res = total <= target ? Math.max(res, total) : res;
                    }
                }
            }
        }
        return res;
    }
}


// lower、floor、ceiling 和 higher 分别返回小于、小于等于、大于等于、大于给定元素的元素，如果不存在这样的元素，则返回 null。
// min(m,n)^2*max(m,n)*log(max(m,n))
public class Solution {
    /*  https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/
        first  consider the situation matrix is 1D
        we can save every sum of 0~i(0<=i<len) and binary search previous sum to find 
        possible result for every index, time complexity is O(NlogN).
        so in 2D matrix, we can sum up all values from row i to row j and create a 1D array 
        to use 1D array solution.
        If col number is less than row number, we can sum up all values from col i to col j 
        then use 1D array solution.
    */
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0)
            return 0;
        int col = matrix[0].length;
        int m = Math.min(row,col);
        int n = Math.max(row,col);
        //indicating sum up in every row or every column
        boolean colIsBig = col > row;
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; i++){
            int[] array = new int[n];
            // sum from row j to row i
            for(int j = i; j >= 0; j--){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                //traverse every column/row and sum up
                for(int k = 0; k < n; k++){
                    array[k] = array[k] + (colIsBig ? matrix[j][k]: matrix[k][j]);
                    val = val + array[k];
                    //use  TreeMap to binary search previous sum to get possible result 
                    Integer subres = set.ceiling(val - target);
                    if(null != subres){
                        res = Math.max(res,val - subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}