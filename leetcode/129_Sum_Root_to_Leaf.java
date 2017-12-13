/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 12.12 全局变量help
class Solution {
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, root.val);
        return sum;
    }
    private void helper(TreeNode root, int pre) {
        if (root.left == null && root.right == null)
            sum = sum + pre;
        if (root.left != null)
            helper(root.left, pre * 10 + root.left.val);
        if (root.right != null)
            helper(root.right, pre * 10 + root.right.val);
    }
}