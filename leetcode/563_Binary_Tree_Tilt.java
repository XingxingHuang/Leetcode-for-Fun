/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 10.10 global variable and recursive
class Solution {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
}

// without global 

public int findTilt(TreeNode root) {
    int[] ret = new int[1];
    helper(root, ret);
    return ret[0];
}
    
private int helper(TreeNode node, int[] ret){
    if(node == null){
        return 0;
    }
    int l_sum = helper(node.left, ret);
    int r_sum = helper(node.right, ret);
    ret[0] += Math.abs(l_sum - r_sum);
    return l_sum + r_sum + node.val
}