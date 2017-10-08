class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int count = explore(grid, i, j, m, n, visited, 0);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
    public int explore(int[][] grid, int x, int y, int m, int n, boolean[][] visited, int count) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return count;
        } 
        count++;
        visited[x][y] = true; 
        for (int i = 0; i < dir.length; i++) {
            count = explore(grid, x + dir[i][0], y + dir[i][1], m, n, visited, count);
        }
        return count;
    }
}