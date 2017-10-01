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
    // private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        // left deepest        
        int left = 0;
        if (root.left != null && root.left.val == root.val) {
            left = 1 + longestSingle(root.left);
        } 
        // right deepest
        int right = 0;
        if (root.right != null && root.right.val == root.val) {
            right = 1 + longestSingle(root.right);
        }
        max = Math.max(max, longestUnivaluePath(root.left));
        max = Math.max(max, longestUnivaluePath(root.right));
        max = Math.max(max, left + right);
        return max;
    }
    private int longestSingle(TreeNode root) {
        if (root == null) return 0;
        int longest = 0;
        if (root.left != null && root.left.val == root.val) 
            longest =  1 + longestSingle(root.left);
        if (root.right != null && root.right.val == root.val)
            longest = Math.max(longest, 1 + longestSingle(root.right));
        return longest;
    }


// https://leetcode.com/articles/longest-univalue-path/
// recursive, the same idea with mine, but more concise
//  for each node, we want to know what is the longest possible arrow extending left, 
// and the longest possible arrow extending right? We can solve this using recursion.
class Solution {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left)
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}