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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        postTravel(root, res);
        return res;
    }
    public void postTravel(TreeNode root, ArrayList<Integer> res) {
        if (root != null) {
            postTravel(root.left, res);
            postTravel(root.right, res);
            res.add(root.val);
        }
    }
}