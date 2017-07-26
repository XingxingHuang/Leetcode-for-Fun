/**
 * 主要弄清题目意思，矩阵的每个数值表示该点的高度。假设这个点的水向四周流动，输出可以流动到两个大洋的点。
 * 可以从四周逐渐抬高水量，看某个点是否会同时开始被两个大洋淹没，问题是如何存储信息。
 * 可以用BFS 或者 DFS 来做
 */

// @Author: Xingxing Huang
public class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return res;
            
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] flag1 = new boolean[m][n]; // visited or not
        boolean[][] flag2 = new boolean[m][n]; // visited or not
        Queue<int[]> queue1 = new LinkedList<>(); 
        Queue<int[]> queue2 = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {  // 行
            queue1.offer(new int[]{i, 0});
            flag1[i][0] = true;
            queue2.offer(new int[]{i, n - 1});
            flag2[i][n - 1] = true;
        } 
        for (int j = 0; j < n; j++) {  // 列
            queue1.offer(new int[]{0, j});
            flag1[0][j] = true;
            queue2.offer(new int[]{m - 1, j});
            flag2[m - 1][j] = true;
        }
        
        helper(matrix, queue1, flag1, m, n);
        helper(matrix, queue2, flag2, m, n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag1[i][j] && flag2[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    // BFS
    private void helper(int[][] matrix, Queue<int[]> queue, 
                        boolean[][] flag,
                        int m, int n) {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] dir : dirs) {
                int x = now[0] + dir[0];
                int y = now[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && 
                        !flag[x][y] && matrix[x][y] >= matrix[now[0]][now[1]]) {
                    queue.offer(new int[]{x, y});
                    flag[x][y] = true;
                }
            }
        }
    }
}

// dfs 

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(new int[] {i, j});
        return res;
    }
    
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d:dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }
}