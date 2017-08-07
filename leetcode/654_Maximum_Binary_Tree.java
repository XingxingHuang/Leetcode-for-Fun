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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null)
            return null;
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int m, int n) {
        if (m > n) 
            return null;
        int idx = m;
        for (int i = m + 1; i <= n; i++) {
            if (nums[idx] < nums[i])
                idx = i;
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, m, idx - 1);
        root.right = helper(nums, idx + 1, n);
        return root;
    }
}