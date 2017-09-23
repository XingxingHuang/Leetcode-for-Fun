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

// 09.22,  相同的方法，但是子函数不一样导致代码行数增加了不少
class Solution {
    private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j] == 1 || grid[i][j] != '1') continue;
                count++;
                Queue<int[]> queue = new LinkedList<>();
                // System.out.println(i+ " "+ j);
                queue.offer(new int[] {i, j});
                flag[i][j] = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] pos = queue.poll();
                        for (int[] dir: dirs) {
                            int x = pos[0] + dir[0];
                            int y = pos[1] + dir[1];
                            if (valid(x, y, m, n, flag, grid)) {
                                queue.offer(new int[]{x, y});
                                flag[x][y] = 1;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    private boolean valid(int x, int y, int m, int n, int[][] flag, char[][] grid) {
        if (x < 0 || x >= m) return false;
        if (y < 0 || y >= n) return false;
        if (grid[x][y] == '0') return false;
        if (flag[x][y] == 1) return false;
        return true;
    }
}