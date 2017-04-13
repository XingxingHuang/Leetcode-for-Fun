/**
 * @Author: Xingxing Huang
 * @Author: 2017.04.13
 * @ 递归解法 和 全局变量解法
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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfNode(root);
    }
    public int diameterOfNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 任意节点的diameter为左深度和右深度和+1, 然后求得最大值
        int diameter = depthOfNode(root.right) + depthOfNode(root.left);
        return Math.max(Math.max(diameterOfNode(root.left), diameterOfNode(root.right)), diameter);
    }
    public int depthOfNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 深度为左边和右边深度最大加1
        return Math.max(depthOfNode(root.left), depthOfNode(root.right)) + 1;
    }
}


public class Solution {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        depthOfBinaryTree(root);
        return max;
    }
    public int depthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depthOfBinaryTree(root.left);
        int right = depthOfBinaryTree(root.right);
        // 添加一行修改全局变量即可
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}