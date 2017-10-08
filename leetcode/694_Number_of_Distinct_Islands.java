//10.07
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    String str = explore(grid, i, j, m, n, visited, "", "xx");
                    set.add(str);
                }
            }
        }
        return set.size();
    }
    public String explore(int[][] grid, int x, int y, int m, int n, boolean[][] visited, String str, String prefix) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        String[] prefixs = new String[]{"00", "01", "10", "11"};
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return str+"|";
        } 
        str += prefix;
        visited[x][y] = true; 
        for (int i = 0; i < dir.length; i++) {
            str = explore(grid, x + dir[i][0], y + dir[i][1], m, n, visited, str, prefixs[i]);
        }
        return str;
    }
}