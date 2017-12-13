/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 12.12 good exercise
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int idx, int begin, int end) {
        // 注意这里需要有两个限制条件
        if (idx > preorder.length - 1 || begin > end)
            return null;
        TreeNode root = new TreeNode(preorder[idx]);
        int idx_ = 0;  // 这个index是在preorder中左右子树的分界线    
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == preorder[idx]) 
                idx_ = i;
        }
        // inorder   [left tree] [root: idx_] [right tree]
        // preorder  [root: idx] [left tree] [idx + 1 + idx_ - begin, right tree]
        root.left = helper(preorder, inorder, idx + 1, begin, idx_ - 1);
        root.right = helper(preorder, inorder, idx + idx_ - begin + 1, idx_ + 1, end);
        return root;
    }
}