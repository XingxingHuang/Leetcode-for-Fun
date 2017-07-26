// Author: Xingxing Huang
public class Solution {
    public int totalNQueens(int n) {
        int[] cols = new int[n];
        return dfs(n, cols, 0, 0);
    }
    private int dfs(int n, int[] cols, int count, int idx) {
        if (idx == n) {
            ++count;
            return count;
        }
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int row = 0; row < idx; row++) {
                if (i == cols[row] || idx + i == row + cols[row] || idx - i == row - cols[row]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                cols[idx] = i;
                count = dfs(n, cols, count, idx + 1);
            }
        }
        return count;
    } 
}


// solution
public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }
    
    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;
            
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}