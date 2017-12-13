/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 12.12
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end, int idxPostorder) {
        if (start > end || idxPostorder < 0) 
            return null;
        int idxInorder = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == postorder[idxPostorder]) {
                idxInorder = i;
            }
        }
        TreeNode node = new TreeNode(postorder[idxPostorder]);
        int rightSize = end - idxInorder; // size of right branch
        node.left = helper(inorder, postorder, start, idxInorder - 1, idxPostorder - 1 - rightSize);
        node.right = helper(inorder, postorder, idxInorder + 1, end, idxPostorder - 1);
        return node;
    }
}