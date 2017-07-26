/**
 * 注意分治的思想，分析tree的性质确定状态要求。分治的时候使用了递归方法。
 * @author  Xingxing Huang  
 * @since   2017.04.18
 * @Time    O(n)    
 * @param   
 * @return  
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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    public int maxDepth(TreeNode root) {
        // return -1: not balanced
        // return depth if balanced
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}