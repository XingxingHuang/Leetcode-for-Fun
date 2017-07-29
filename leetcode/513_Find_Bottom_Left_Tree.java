/**
 * @Author: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: O(n), BFS遍历，但是遍历的时候注意进出栈顺序即可。
 * 每次只需要记录一个节点即可，出队列的最后一个元素即为最左元素
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        return node.val;
    }
}