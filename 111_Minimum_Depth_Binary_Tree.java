// Author: Xingxing Huang
// Data: 2017/03/24
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // This calculate the min depth
        // if (root.left == null || root.right == null) {
        //     return 1;
        // }
        // return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}