/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: O(n), DFS. 这里注意对left左子树也需要添加修改。
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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        helper(root, 0);
        return root;
    }
    public int helper(TreeNode root, int sum) {
        // sum is the total of father and the right tree.
        if (root == null) {  
            return sum; 
        }            
        root.val += helper(root.right, sum);
        sum = root.val; // 注意这里的sum的传值
        if (root.left != null) {
            sum = helper(root.left, sum);
            return sum;
        }
        return root.val;
    }
}

public class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}