// http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/
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
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    // public ArrayList<Integer> inorderTraversal(TreeNode root) {
    //     // write your code here
    //     ArrayList<Integer> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     res.addAll(inorderTraversal(root.left));
    //     res.add(root.val);
    //     res.addAll(inorderTraversal(root.right));
    //     return res;
    // }
    
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}