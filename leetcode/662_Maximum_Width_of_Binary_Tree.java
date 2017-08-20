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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) 
            return 0;
        
        int max = 1;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>(); // for idx 
        queue.offer(root);
        queue2.offer(0);
        while (!queue.isEmpty()) {
            int left = Integer.MAX_VALUE;
            int right = -1;
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                Integer idx = queue2.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    queue2.offer(idx * 2);
                    left = Math.min(idx * 2, left);
                    right = Math.max(idx * 2, right);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    queue2.offer(idx * 2 + 1);
                    left = Math.min(idx * 2 + 1, left);
                    right = Math.max(idx * 2 + 1, right);
                }
            }
            if (right != -1 && left != Integer.MAX_VALUE) 
                max = Math.max(max, right - left + 1 );
        }
        return max;
    }
}