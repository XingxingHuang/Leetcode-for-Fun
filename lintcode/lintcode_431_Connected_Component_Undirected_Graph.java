/**
 * http://www.lintcode.com/en/problem/connected-component-in-undirected-graph/
 * Find the number connected component in the undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected component (or just component) of an undirected graph 
 * is a subgraph in which any two vertices are connected to each other by paths,
 * and which is connected to no additional vertices in the supergraph.)
 * 
 * 九章提供了bfs和union find 两种解法。
 * http://www.jiuzhang.com/solutions/find-the-connected-component-in-the-undirected-graph/
 */
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        HashSet<UndirectedGraphNode> hashSet = new HashSet<UndirectedGraphNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (UndirectedGraphNode node: nodes) {
            if (!hashSet.contains(node)) {
                // 将所有node相邻的元素加入ans中，hashSet记录访问过的元素。
                ArrayList<Integer> ans = new ArrayList<Integer>();
                bfs(node, ans, hashSet);
                //res.add(ans);
                Collections.sort(ans);
                res.add(ans);
            }
        }
        return res;
    }
    public void bfs(UndirectedGraphNode node, ArrayList<Integer> ans, 
                HashSet<UndirectedGraphNode> hashSet) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        hashSet.add(node);  // 注意这个程序的位置，加入queue必须马上标志为访问
        while (!queue.isEmpty()) {
            UndirectedGraphNode now = queue.poll();
            // do something
            ans.add(now.label);
            // add elements
            for (UndirectedGraphNode nb: now.neighbors) {
                if (!hashSet.contains(nb)) {
                    hashSet.add(nb);
                    queue.offer(nb);
                }
            }
        }
    }
}