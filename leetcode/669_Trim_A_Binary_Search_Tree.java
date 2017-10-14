/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 10.12
// recursive method for tree manipulations
// trimBST的定义为返回root树中在L，R区间的部分。
// 因此先检查头结点root，分null，<L, >R的三种边界情况。如果root在L,R范围内，那么对左子树和右子树分别进行剪枝操作。
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L)
            return trimBST(root.right, L, R);
        else if (root.val > R)
            return trimBST(root.left, L, R);
        else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}


