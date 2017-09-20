/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 09.16 BFS for Tree 
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        // corner case
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        // move to level d - 1
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (level < d - 1) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            level++;
        }
        // add to level d
        int size = q.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            node.left = new TreeNode(v);
            node.left.left = left;
            TreeNode right = node.right;
            node.right = new TreeNode(v);
            node.right.right = right;
        }
        return root;
    }
}