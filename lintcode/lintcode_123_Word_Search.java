// http://www.lintcode.com/en/problem/word-search/
// BFS 搜索
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) {
            return true;
        }
        if (valid(board, i, j) && board[i][j] == word.charAt(start)) {
            board[i][j] = '#'; // 访问记录
            boolean res = helper(board, i - 1, j, word, start + 1) ||
                    helper(board, i + 1, j, word, start + 1) || 
                    helper(board, i, j - 1, word, start + 1) ||
                    helper(board, i, j + 1, word, start + 1);
            board[i][j] = word.charAt(start); // 恢复访问
            if (res) {
                return res;
            }
        } 
        return false;
    }
    private boolean valid(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        } else {
            return true;
        }
    }
}