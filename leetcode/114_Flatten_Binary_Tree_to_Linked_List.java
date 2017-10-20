/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 10.20 recursive
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) 
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // left
        flatten(left);
        root.right = left;
        root.left = null;
        // right
        flatten(right);
        TreeNode head = root;
        while (head.right != null) 
            head = head.right;
        head.right = right;
    }
}

// non-recursive
class Solution {
    public void flatten (TreeNode root) {
        if (root == null) 
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            if (!stack.isEmpty())
                node.right = stack.peek();
        }
    }
}


// more clearly

class Solution {
    public void flatten (TreeNode root) {
        if (root == null) 
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            if (!stack.isEmpty())
                node.right = stack.peek();
        }
    }
}