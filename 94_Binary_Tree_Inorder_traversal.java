/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 改写成interatively method 不是那么容易
 * @author  Xingxing Huang  
 * @since   2017.04.17
 * @Time    O(n),   
 * @param   TreeNode
 * @return  List
 */
// iteratively method
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
// // Recursive method
// public class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         helper(root, res);
//         return res;
//     }
//     public void helper(TreeNode root, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         helper(root.left, res);
//         res.add(root.val);
//         helper(root.right, res);
//     }
// }