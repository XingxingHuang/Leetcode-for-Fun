/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 10.20   Time exceed
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int max = root.val + pathSum(root.left) + pathSum(root.right);
        if (root.left != null) 
            max = Math.max(max, maxPathSum(root.left));
        if (root.right != null)
            max = Math.max(max, maxPathSum(root.right));
        return max;
    }
    private int pathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(pathSum(root.left), 0);
        int right = Math.max(pathSum(root.right), 0);
        return Math.max(0, root.val + Math.max(left, right));
    }
}

// attention, corner case global variable
class Solution {
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        pathSum(root);
        return max;
    }
    private int pathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(pathSum(root.left), 0);
        int right = Math.max(pathSum(root.right), 0);
        max = Math.max(max, root.val);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}