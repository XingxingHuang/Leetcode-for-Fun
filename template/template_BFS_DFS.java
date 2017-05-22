/** @Author: XingxingHuang
 *  @Date: 2017.4.11
 * 102_Binary_Tree_Level_Traversal_I.java
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 新建存储结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        // dfs, 传递数据，结果，计数
        levelAdd(root, res, 0);
        return res;
    }
    public void levelAdd(TreeNode root, List<List<Integer>> res, int level) {
        // 特殊情况判断
        if (root == null) {
            return;
        }
        // 情况判断，加入新数据
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        // 把递归写在后面，避免递归的时候已经改变res而出问题
        levelAdd(root.left, res, level + 1);
        levelAdd(root.right, res, level + 1);
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 新建存储结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        // 特殊情况判断
        if (root == null) {
            return res;
        }
        // BFS 初始化
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            // 遍历每个状态，每次出队列，加入新的元素.
            // 注意循环结果的判断, 注意出队列的代码位置。
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) {  
                    queue.offer(queue.peek().left);  // 入队列 
                }
                if (queue.peek().right != null) { 
                    queue.offer(queue.peek().right); // 入队列 
                }
                list.add(queue.poll().val);          // 出队列
            }
            res.add(list);                   
        }
        return res;
    }
}