/**
 * @Author: Xingxing Huang
 * @Date: 2017.04.12
 * @Time: DFS && BFS
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
// BFS
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }
    public boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return help(left.right, right.left) && help(left.left, right.right);
        }
        return false;
    }
}

// DFS，可以用LinkedList代替每次放两个node，取出两个node
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null || root.left.val != root.right.val) {
            return false;
        } 
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while(!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (!checkValid(left.left, right.right)) {
                return false;
            } else if (left.left != null && right.right != null) {
                deque.addFirst(left.left);
                deque.addLast(right.right);
            }
            if (!checkValid(left.right, right.left)) {
                return false;
            } else if (left.right != null && right.left != null) {
                deque.addFirst(left.right);
                deque.addLast(right.left);
            }
        }
        return true;
    }
    public boolean checkValid (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
                return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        } 
        return true;
    }
}
