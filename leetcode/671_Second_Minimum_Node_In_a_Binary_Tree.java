/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// recursive way. The minimum value must be the root. 
// We should be careful that both left and right nodes can be equal to the root.
// so this problem can be solved in recursive way.
class Solution {
    private int minValue = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (minValue != -1 && root.val != minValue)
            return root.val;
        minValue = root.val;
        
        if (root.left == null || root.right == null) return -1;
        int r1 = findSecondMinimumValue(root.left);
        int r2 = findSecondMinimumValue(root.right);
        if (r1 == -1 && r2 == -1) 
            return -1;
        else if (r1 == -1) 
            return r2;
        else if (r2 == -1)
            return r1;
        else 
            return Math.min(r1, r2);
    }
}


public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        return helper(root, root.val);
    }
    public int helper(TreeNode node, int val){
        if(node == null)
            return -1;
        if(node.val != val)
            return node.val;
        int left = helper(node.left, val);
        int right = helper(node.right, val);
        if(left == -1 || right == -1){
            return Math.max(left, right);
        }
        return Math.min(left, right);
    }
}