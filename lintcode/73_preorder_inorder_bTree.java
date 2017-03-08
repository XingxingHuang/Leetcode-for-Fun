// @Author Xingxing Huang
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null
                || preorder.length != inorder.length
                || inorder.length < 1) {
            return null;
        }
        return addNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode addNode(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
        if (p1 > p2) {
            return null;
        }
        // create root
        TreeNode root = new TreeNode(preorder[p1]);
        int index = 0;
        while (index + i1 < i2 && inorder[index + i1] != preorder[p1]) {
            index++;
        }
        // number of left tree: index
        // preorder: root, left, right  p1 + 1, p1 + index, p1 + index + 1, p2
        // inorder : left, root, right  i1, i1 + index - 1, i1 + index + 1, i2
        root.left = addNode(preorder, inorder, p1 + 1, p1 + index, i1, i1 + index - 1);
        root.right = addNode(preorder, inorder, p1 + index + 1, p2, i1 + index + 1, i2);
        return root;
    }
}