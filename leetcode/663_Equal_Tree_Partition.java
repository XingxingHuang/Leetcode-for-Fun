/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) 
            return false;
        int sum = getsum(root);
        if (sum % 2 != 0) 
            return false;
        return check(root, sum / 2);
    }
    private int getsum(TreeNode root) {
        if (root == null) 
            return 0;
        return root.val + getsum(root.left) + getsum(root.right);
    }
    private boolean check(TreeNode root, int sum) {
        if (root == null) 
            return false;
        if ((getsum(root.left) == sum && root.left != null) || (getsum(root.right) == sum && root.right != null))
            return true;
        return check(root.left, sum) || check(root.right, sum);
    }
}



class Solution {
    
    private List<Integer> set = new ArrayList<>();
    
    public boolean checkEqualTree(TreeNode root) {
        
        int temp = help(root);
        set.remove(set.size()-1);
        
        for (int s : set) {
            if (s * 2 == temp)
                return true;
        }
        
        return false;
    }
    
    private int help(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = help(node.left);
        int right = help(node.right);
        
        int ans = node.val + left + right;
        
        set.add(ans);
        
        return ans;
    }
}