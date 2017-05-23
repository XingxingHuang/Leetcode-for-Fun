// http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// public class Solution {
//     /**
//      * @param root: The root of binary tree.
//      * @return: An integer.
//      */
//     public int maxPathSum(TreeNode root) {
//         // write your code here
//     }
// }

// public class Solution {
//     public int maxPathSum(TreeNode root) {
//         int res = 0;
//         if (root == null) {
//             return Integer.MIN_VALUE;
//         }
//         int left = helper(root.left);
//         int right = helper(root.right);
//         res = root.val + Math.max(0, left) + Math.max(0, right);
//         res = Math.max(res, maxPathSum(root.left));
//         res = Math.max(res, maxPathSum(root.right));
//         return res;
//     }
//     public int helper(TreeNode root) {
//         int res = 0;
//         if (root == null) {
//             return res;
//         }
//         return Math.max(root.val + helper(root.left),
//             root.val + helper(root.right));
//     }
// }


public class Solution {
    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}