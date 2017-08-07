/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursive
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return tranverse(root, k, set);
    }
    private boolean tranverse(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        else 
            set.add(root.val);
        return tranverse(root.left, k, set) || tranverse(root.right, k, set);
    }
}
// BFS
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (set.contains(k - node.val )) 
                    return true;
                set.add(node.val);
                if (node.left != null) 
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return false;
    }
}