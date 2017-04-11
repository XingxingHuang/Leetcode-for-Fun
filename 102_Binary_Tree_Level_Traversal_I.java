/** @Author: XingxingHuang
 *  @Date: 2017.4.11
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        levelAdd(root, res, 0);
        return res;
    }
    public void levelAdd(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        // 把递归写在后面，避免递归的时候已经改变res而出问题
        levelAdd(root.left, res, level + 1);
        levelAdd(root.right, res, level + 1);
    }
}