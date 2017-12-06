/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 12.05 Note: Recursive solution is trivial, could you do it iteratively?
// postorder: left, right, root
// 难点，容易考虑用stack记录访问过的节点，但是一个stack在postorder中行不通。
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode p = root;
        while(!dq.isEmpty() || p != null) {
            if(p != null) {
                dq.push(p);
                res.addFirst(p.val);  
                p = p.right;             
            } else {
                TreeNode node = dq.pop();
                p = node.left;           
            }
        }
        return res;
    }
}