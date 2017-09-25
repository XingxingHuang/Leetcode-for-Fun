/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, sum, new ArrayList<>(), res);
        return res;
    }
    private void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root.val == sum && root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<Integer>(list));
        } else {
            list.add(root.val);
            if (root.left != null) 
                helper(root.left, sum - root.val, list, res);
            if (root.right != null) 
                helper(root.right, sum - root.val, list, res);
        }
        list.remove(list.size() - 1);
    }
}

// could use dfs and bfs.
// python in discussion
// https://discuss.leetcode.com/topic/18444/python-solutions-recursively-bfs-queue-dfs-stack