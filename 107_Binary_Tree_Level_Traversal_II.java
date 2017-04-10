/** 
 * @Author: Xingxing Huang
 * @Date: 2017.04.10
 * @Time: 典型DFS BFS题目
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // step1: create variable
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        // step2: corner case
        if(root == null) return wrapList;
        // step3: BFS
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> subList = new LinkedList<Integer>();  // nodes in each level
            for(int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
}


public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        // DFS 直接递推
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        // 加入新层
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        // 这行命令位置不重要
        // list.get(list.size() - level - 1).add(root.val);
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        // 加入元素
        list.get(list.size() - level - 1).add(root.val);
    }
}
