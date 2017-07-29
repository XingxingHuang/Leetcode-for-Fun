/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: O(mn), DFS 很好写，但是效率不高
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    explore(grid, i, j, m, n, visited);
                }
            }
        }
        return res;
    }
    public void explore(char[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0' || visited[x][y]) {
            return;
        } 
        visited[x][y] = true; 
        for (int i = 0; i < dir.length; i++) {
            explore(grid, x + dir[i][0], y + dir[i][1], m, n, visited);
        }
    }
}