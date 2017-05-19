/**
 * http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
 * Find the number Weak Connected Component in the directed graph. 
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected set of a directed graph is a subgraph 
 * in which any two vertices are connected by direct edge path.)
 */
 
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

class UnionFind {
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
    
    UnionFind(HashSet<Integer> hashSet) {
        for (Integer now: hashSet) {
            father.put(now, now);
        }
    }
    
    int find(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        return parent;
    }
    
    // // 压缩版本的find，每次更新路径上的parent
    // int compressed_find(int x) {
    //     int parent = father.get(x);
    //     while (parent != father.get(parent)) {
    //         parent = father.get(parent);
    //     }
    //     int temp = -1;
    //     int fa = father.get(x);
    //     while (fa != father.get(fa)) {
    //         temp = father.get(fa);
    //         father.put(fa, parent);
    //         fa = temp;
    //     }
    //     return parent;
    // }
    
    void union (int x, int y) {
        int fa_x = find(x);
        int fa_y = find(y);
        if (fa_x != fa_y) {
            father.put(fa_x, fa_y);
        }
    }
}

public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        // 保存所有节点值进入HashSet
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (DirectedGraphNode now: nodes) {
            hashSet.add(now.label);
            for (DirectedGraphNode nb: now.neighbors) {
                hashSet.add(nb.label);
            }
        }
        // 存储unionfind信息，在unionfind中合并头结点。
        UnionFind uf = new UnionFind(hashSet);
        for (DirectedGraphNode now: nodes) {
            for (DirectedGraphNode nb: now.neighbors) {
                int fnow = uf.find(now.label);
                int fnb = uf.find(nb.label);
                if (fnow != fnb) {
                    uf.union(now.label, nb.label);
                }
            }
        }
        return print(hashSet, uf, nodes.size());
    }
    
    // 存储输出信息！！
    List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        // 记录每个father对应的node集合
        for (int i: hashSet) {
            int fa = uf.find(i);
            if (!hashMap.containsKey(fa)) {
                hashMap.put(fa, new ArrayList<Integer>());
            }
            hashMap.get(fa).add(i);
        }
        // 输出结果到数组中。
        for (List<Integer> now: hashMap.values()) {
            Collections.sort(now);
            ans.add(now);
        }
        return ans;
    }    
}