// @Author: Xingxing Huang
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int level = 0;
        addLevel(root, res, level);
        return res;
    }
    
    public void addLevel(TreeNode root, 
            ArrayList<ArrayList<Integer>> res, 
            int level) {
        if (root == null) {
            return;
        }
        if (res.size() < level + 1) {
            res.add(new ArrayList<Integer>());
        } 
        res.get(level).add(root.val);
        addLevel(root.left, res, level + 1);
        addLevel(root.right, res, level + 1);
    }
}