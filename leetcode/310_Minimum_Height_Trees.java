/**
 * 给定图，找到深度最小的树的头结点。那么这个头结点应该是两个最长叶子结点的中点。考虑双指针的思想。
 * 我们可以很容易根据叶子结点特性(度为1)，找到所有的叶子结点。
 * 所有的叶子结点往中间移动，每次移动一步，删除叶子结点，并找到新的叶子结点
 * 最后留下的一个结点，或者两个结点即为所求树的头结点。
 * check solution for other ideas:
 * https://discuss.leetcode.com/topic/30956/two-o-n-solutions
 * @author  Xingxing Huang  
 * @since   2017.05.10  
 * @Time    O(n)    
 * @param   int, int[][]
 * @return  List<Integer>
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            //return Collections.singletonList(0);
            return new ArrayList<Integer>(Arrays.asList(0));
        }
        // 记录每个结点相邻结点。
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // 叶子节点为那些度为1的点。
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);
            
        // 找到头结点
        while (n > 2) {
            n -= leaves.size();  // 每次删除叶节点，总结点数目降低
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i); // 移除叶节点
                if (adj.get(j).size() == 1) newLeaves.add(j); // 如果为变为叶节点，那么加入。
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}


// 12.21 
// 错误思路(无法解决nodes重复访问)，先找到枝叶，然后顺着枝叶往里面找，每次更新路径上node的height。最后遍历nodes，返回height等于最大值的那些nodes。
// 改进，从枝叶开始遍历是，每次删除访问过枝叶，然后访问之后的枝叶。
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // corner case
        if (n == 1) 
            return new ArrayList<Integer>(Arrays.asList(0));  // Collections.singletonList(0);
        // 创建图，用邻接点记录
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) 
            graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }    
        // 找出枝叶
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        // 遍历枝叶
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newleaves = new ArrayList<>();
            for (int node: leaves) {
                int i = graph.get(node).iterator().next();
                graph.get(i).remove(node);
                if (graph.get(i).size() == 1) 
                    newleaves.add(i);
            }
            leaves = newleaves;
        }
        return leaves;
    }
}