/**
 * 无向图的拷贝。给定一个节点，采用BFS或者DFS来遍历整个图。先复制节点信息，再复制边信息。
 * 相关题目，leetcode 138，拷贝带随机节点的链表(非哈希表解法)。
 * 注： Nodes are labeled uniquely. 可以用label作为哈希表的key。
 * @author  Xingxing Huang  
 * @since   2017.05.10  
 * @Time    O(n)    
 * @param   node (头结点)
 * @return  node (头结点)
 */
 
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// DFS 
// 主要node为空，neighbor为空的判断。
public class Solution {
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) {
            return null;
        }
        // node already copied
        if (map.containsKey(node)) {
            return map.get(node);
        }
        // copy neighbors
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        newNode.neighbors = new ArrayList<UndirectedGraphNode>();
        if (null != node.neighbors) {
            for (UndirectedGraphNode nb: node.neighbors) {
                newNode.neighbors.add(cloneGraph(nb));
            }
        }
        return newNode;
    }
}

// BFS template 
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) 
            return null;
        // init map and queue
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        
        // init root node
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        UndirectedGraphNode res = newNode;
        map.put(node, res);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                node = queue.poll();
                ArrayList<UndirectedGraphNode> nbs = new ArrayList<>();
                for (int j = 0; j < node.neighbors.size(); j++) {
                    // copy neightbors
                    if (!map.containsKey(node.neighbors.get(j))) {
                        newNode = new UndirectedGraphNode(node.neighbors.get(j).label);
                        map.put(node.neighbors.get(j), newNode);
                        queue.offer(node.neighbors.get(j));
                    } 
                    newNode = map.get(node.neighbors.get(j));
                    nbs.add(newNode);
                }
                // set edge
                map.get(node).neighbors = nbs;
            }
        }
        return res;
    }
}

// BFS more compact 
// remove one for loop
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) 
            return null;
        // init map and queue
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        
        // init root node
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node, res);
        
        while (!queue.isEmpty()) {
            node = queue.poll();
            ArrayList<UndirectedGraphNode> nbs = new ArrayList<>();
            for (int j = 0; j < node.neighbors.size(); j++) {
                // copy neightbors
                if (!map.containsKey(node.neighbors.get(j))) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(node.neighbors.get(j).label);
                    map.put(node.neighbors.get(j), newNode);
                    queue.offer(node.neighbors.get(j));
                } 
                nbs.add(map.get(node.neighbors.get(j)));
            }
            // set edge
            map.get(node).neighbors = nbs;
        }
        return res;
    }
}