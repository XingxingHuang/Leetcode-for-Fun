// http://www.lintcode.com/en/problem/max-tree/
// 递归求解，分析建立树的时候的规律。

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
//      * @param A: Given an integer array with no duplicates.
//      * @return: The root of max tree.
//      */
//     public TreeNode maxTree(int[] A) {
//         // write your code here
//         if (A == null || A.length == 0) {
//             return null;
//         }
//         return helper(A, 0, A.length - 1);
//     }
//     private TreeNode helper(int[] A, int start, int end) {
//         if (A == null || A.length < 1 || start > end) {
//             return null;
//         }
//         TreeNode root = new TreeNode(A[start]);
//         for (int i = start + 1; i <= end; i++) {
//             if (A[i] > root.val) {
//                 TreeNode node = new TreeNode(A[i]);
//                 node.left = root;
//                 root = node;
//             } else {
//                 root.right = helper(A, i, end);
//             }
//         }
//         return root;
//     }
// }


// 非递归解法
public class Solution {
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < A.length; i++) {
            TreeNode node = new TreeNode(A[i]);
            while (!stack.isEmpty() && node.val >= stack.peek().val) {
                node.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }

        TreeNode rst = stack.pop();
        while(!stack.isEmpty()) {
            rst = stack.pop();
        }
        return rst;
    }
}
