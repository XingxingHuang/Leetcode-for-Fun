/**
 * @Author: Xingxing Huang
 * @Date: 2017.04.12
 * @Time: BFS
 */
public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();   
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
            return res;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        int m = matrix.size();
        int n = matrix.get(0).size();
        // 初始化结果矩阵，计算0的地方的值
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    list.add(0);
                    queue.offer(new int[] {i, j});
                } else {
                    list.add(Integer.MAX_VALUE);
                }
            }
            res.add(list);
        }
        // 对每一个0位置，对四个方向，进行BFS搜索
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (checkValid(x, y, m, n, res) && 
                        res.get(cell[0]).get(cell[1]) + 1 < res.get(x).get(y)) {
                    queue.offer(new int[] {x, y});
                    res.get(x).set(y, res.get(cell[0]).get(cell[1]) + 1);
                } 
            }
        }
        return res;
    }
    public boolean checkValid(int x, int y, int m, int n, List<List<Integer>> res) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return true;
    }
}