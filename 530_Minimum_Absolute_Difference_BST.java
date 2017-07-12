// BST 的中序遍历就是按照从小到大的顺序排列，找到其中的最小值即可。
// 可以使用全局变量，但是注意全局变量的时候，需要判断  pre != Integer.MIN_VALUE
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
    int pre = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) 
            return min;
        helper(root);
        return min;
    }
    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        if (pre != Integer.MIN_VALUE) {  // attention
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        helper(root.right);
    }
}


// if it is not BST
public class Solution {
    TreeSet<Integer> set = new TreeSet<>();
    int min = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }
        
        set.add(root.val);
        
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        
        return min;
    }
}