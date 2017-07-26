/**
 * DFS BFS 均可, 这题注意起始点和root=null时候的判断。
 * @athor   Xingxing Huang  
 * @since   2017.04.14  
 * @Time    O(n)    
 * @param   TreeNode
 * @return  List<String>
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, "");
        return res;
    }
    public void helper(TreeNode root, List<String> res, String sub) {
        if (root.left == null && root.right == null) {
            res.add(sub + root.val);
        }
        sub += root.val + "->";
        if (root.left != null) {
            helper(root.left, res, sub);
        }
        if (root.right != null) {
            helper(root.right, res, sub);
        }
    }
}

        // if (root == null) {
        //     res.add(sub);
        //     return;
        // } 
        // if (sub.length() == 0) {
        //     sub = "" + root.val;
        // } else {
        //     sub += "->" + root.val;
        // }
        // helper(root.left, res, sub);
        // helper(root.right, res, sub);