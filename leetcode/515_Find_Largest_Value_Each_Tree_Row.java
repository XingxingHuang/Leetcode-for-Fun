/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: O(n), BFS, 典型练习题，按层遍历
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(Integer.MIN_VALUE);
        }
        if (root.val > res.get(level)) {
            res.set(level, root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}


// BFS
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.val > max) {
                    max = node.val;
                }
            }
            res.add(max);
        }
    return res;
    }
}