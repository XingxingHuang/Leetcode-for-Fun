// http://www.lintcode.com/en/problem/graph-valid-tree/#
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        // 用邻接表存储图结构
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        // bfs 搜索;
        Queue<Integer> queue = new LinkedList<>(); //bfs专用队列
        Set<Integer> hash = new HashSet<>(); //是否重复访问
        queue.offer(0);
        hash.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer nbs: graph.get(node)) {
                if (!hash.contains(nbs)) {
                    hash.add(nbs);
                    queue.offer(nbs);
                } else {
                    continue;
                }
            }
        }
        // 是否已经遍历全部元素。
        return hash.size() == n;
    }
    
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // 注意这一行，否则无法通过测试！！！！！
        graph.put(0, new HashSet<Integer>());
        for (int i = 0; i < edges.length; i++) {
            // if (!graph.containsKey(edges[i][0])) {
            //     graph.put(edges[i][0], new HashSet<Integer>(edges[i][1]));
            // } else {
            //     graph.get(edges[i][0]).add(edges[i][1]);
            // }
            // if (!graph.containsKey(edges[i][1])) {
            //     graph.put(edges[i][1], new HashSet<Integer>(edges[i][0]));
            // } else {
            //     graph.get(edges[i][1]).add(edges[i][0]);
            // }
            if (!graph.containsKey(edges[i][0])) {
                graph.put(edges[i][0], new HashSet<Integer>());
            } 
            if (!graph.containsKey(edges[i][1])) {
                graph.put(edges[i][1], new HashSet<Integer>());
            } 
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }
    
    // private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
    //     Map<Integer, Set<Integer>> graph = new HashMap<>();
    //     for (int i = 0; i < n; i++) {
    //         graph.put(i, new HashSet<Integer>());
    //     }
        
    //     for (int i = 0; i < edges.length; i++) {
    //         int u = edges[i][0];
    //         int v = edges[i][1];
    //         graph.get(u).add(v);
    //         graph.get(v).add(u);
    //     }
        
    //     return graph;
    // }
}