

// 白鹤开心
// Union Find
class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[2010];
        for (int i=0; i<parent.length; i++)
            parent[i] = i;
        
        for (int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            if (find(x) == find(y))
                return edge;
            else
                parent[find(x)] = find(y);
        }
        
        return null;
    }
    
    private int find(int x){
        if (x!=parent[x]){
          parent[x] = find(parent[x]);  
        }
        return parent[x];
    }
}


// bfs 
class Solution {
    Set<Integer> seen = new HashSet();
    int MAX_EDGE_VAL = 2000;

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge: edges) {
            seen.clear();
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() &&
                    dfs(graph, edge[0], edge[1])) {
                return edge;
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        throw new AssertionError();
    }
    public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;
            for (int nei: graph[source]) {
                if (dfs(graph, nei, target)) return true;
            }
        }
        return false;
    }
}


// My wrong answer, the tree could have more than two branch.
// class Solution {
//     public int[] findRedundantConnection(int[][] edges) {
//         Map<Integer, Integer> map = new HashMap<>();
//         Map<Integer, Integer> parents = new HashMap<>();
//         for (int[] edge : edges) {
//             map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
//             map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
//             parents.put(edge[1], edge[0]);
//         }
//         for (int i = 0; i < edges.length; i++) {
//             // Set<Integer> set = map.keySet();
//             // for (Integer key: set) {
//             //     if (map.get(key) == 1) {
//             //         map.remove(key);
//             //         int parent = parents.get(key); // parent - 1
//             //         map.put(parent, map.get(parent) - 1);
//             //     }
//             // }
//             Iterator<Map.Entry<Integer,Integer>> iter = map.entrySet().iterator();
//             while (iter.hasNext()) {
//                 Map.Entry<Integer,Integer> entry = iter.next();
//                 if (entry.getValue() == 1) {
//                     int parent = parents.get(entry.getKey()); 
//                     iter.remove();
//                     map.put(parent, map.get(parent) - 1);
//                 } 
//             }
//         }
//         for (int i = edges.length - 1; i >= 0; i--) {
//             if (map.containsKey(edges[i][0]) && map.containsKey(edges[i][0])) {
//                 return edges[i];
//             }
//         }
//         return edges[-1];
//     }
// }
