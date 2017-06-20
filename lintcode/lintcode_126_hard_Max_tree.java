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
// 非递归解法
public class Solution {
    public TreeNode maxTree(int[] A) {
     if (A == null || A.length == 0) {
         return null;
     }
     Stack<TreeNode> stack = new Stack<TreeNode>();
     for (int i = 0; i < A.length; i++) {
         TreeNode node = new TreeNode(A[i]);
         // left node
         while (!stack.isEmpty() && node.val >= stack.peek().val) {
             node.left = stack.pop();
         }
         // right node
         if (!stack.isEmpty()) {
             stack.peek().right = node;
         }
         // done, push into stack
         stack.push(node);
     }

     TreeNode rst = null;
     while (!stack.isEmpty()) {
         rst = stack.pop();
     }
     return rst;
    }
}

// 九章算法
// http://www.jiuzhang.com/solution/max-tree/
public class Solution {
    /**
    * @param A
    *            : Given an integer array with no duplicates.
    * @return: The root of max tree.
    */
    public static TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        for (int i = 0; i <= A.length; i++) {
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
                : new TreeNode(A[i]);
            while (!stack.isEmpty()) {
                if (right.val > stack.peek().val) {
                    TreeNode nodeNow = stack.pop();
                    if (stack.isEmpty()) {
                        right.left = nodeNow;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val > right.val) {
                            right.left = nodeNow;
                        } else {
                            left.right = nodeNow;
                        }
                    }
                } else
                    break;
            }
            stack.push(right);
        }
        return stack.peek().left;
    }
}

public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode[] stk = new TreeNode[len];
        for (int i = 0; i < len; ++i)
            stk[i] = new TreeNode(0);
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            TreeNode tmp = new TreeNode(A[i]);
            while (cnt > 0 && A[i] > stk[cnt-1].val) {
                tmp.left = stk[cnt-1];
                cnt --;
            }
            if (cnt > 0)
                stk[cnt - 1].right = tmp;
            stk[cnt++] = tmp;
        }
        return stk[0];
    }
}

// // 递归方法 错误
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
//         if (start > end) {
//             return null;
//         }
//         TreeNode root = new TreeNode(A[start]);
//         // increase 
//         while (++start <= end && A[start] > root.val) {
//             TreeNode node = new TreeNode(A[start]);
//             node.left = root;
//             root = node;
//         }
//         // decrease  // 错误，这里忽略了，最大值在后面的情况
//         if (start <= end && A[start] < root.val) {
//             root.right = helper(A, start, end);
//         }
//         return root;
//         //// 下面这个代码循环次数过多，应该提前在else后面终止。
//         // for (int i = start + 1; i <= end; i++) {
//         //     if (A[i] > root.val) {
//         //         TreeNode node = new TreeNode(A[i]);
//         //         node.left = root;
//         //         root = node;
//         //     } else {
//         //         root.right = helper(A, i, end);
//         //         break;
//         //     }
//         // }
//     }
// }
