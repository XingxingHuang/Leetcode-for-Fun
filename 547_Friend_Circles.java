/**
 * union-find 基本思路
 * @author  Xingxing Huang  
 * @since   2017.04.20
 * @Time    O(n^2 log n),   
 * @param   int[][]
 * @return  int
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        int cnt = 0;
        int[] root = new int[m];
        // init
        for (int i = 0; i < m; i++) {
            root[i] = i;
        }
        // union 
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (M[i][j] == 1) {
                    unionFind(root, i, j);
                }
            }
        }
        // count
        for (int i = 0; i < m; i++) {
            if (i == root[i]) 
                cnt++;
        }
        return cnt;
    }
    public void unionFind(int[] root, int i, int j) {
        while (root[i] != i) i = root[i];
        while (root[j] != j) j = root[j];
        if (root[i] != root[j]) root[j] = i;
    }
}

// DFS method
public class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int count = 0;
        // dfs, record the path.
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] != 1) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, int n, int[] visited) {
        // 指出终止点
        if (visited[n] == 1) {
            return;
        }
        // 处理节点
        visited[n] = 1;
        // 处理所有相邻节点
        //for (int i = n + 1; i < M.length; i++) {
        //    if (M[n][i] == 1) {
        for (int i = 0; i < M.length; i++) {
            if (i != n && M[n][i] == 1) {
                dfs(M, i, visited);
            }
        }
    }
}