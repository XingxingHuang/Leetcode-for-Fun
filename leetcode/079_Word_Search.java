//12.12
// 经典题
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] flag = new boolean[m][n];
                    flag[i][j] = true;
                    if (search(board, i, j, word, 0, m, n, flag)) 
                        return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board, int i, int j, String word, 
                           int idx, int m, int n, boolean[][] flag) {
        if (idx == word.length() - 1) 
            return true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n &&
                    !flag[x][y] && board[x][y] == word.charAt(idx + 1)) {
                flag[x][y] = true;
                if (search(board, x, y, word, idx + 1, m , n, flag))
                    return true;
                flag[x][y] = false;
            }
        }
        return false;
    }
}