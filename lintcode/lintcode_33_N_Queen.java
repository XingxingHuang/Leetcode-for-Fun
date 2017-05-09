// http://www.lintcode.com/en/problem/n-queens/#
// 时间复杂度 O(n!)
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (n <= 0) {
            return res;
        }
        search(res, new ArrayList<Integer>(), n);
        return res;
    }
    // 递归搜索
    private void search(ArrayList<ArrayList<String>> results,
                        ArrayList<Integer> cols,
                        int n) {
        if (cols.size() == n) {
            results.add(drawChessBoard(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    // 返回字符串数组
    private ArrayList<String> drawChessBoard(ArrayList<Integer> cols) {
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) { // 行
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) { // 列
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
    //判断是否有效
    private boolean isValid(ArrayList<Integer> cols, int column) {
        int row = cols.size();
        // 判断是否在列，在两个斜方向。
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
};