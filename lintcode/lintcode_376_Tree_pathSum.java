// Author: Xingxing Huang
// 注意：  传地址而不是传值
//        递归后面需要删除helper元素的存储的最后一位  
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
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) { 
            return result;
        }
        pathSum(root, target, result, list);
        return result;
    }
    public void pathSum(TreeNode root, 
                        int target, 
                        List<List<Integer>> result, 
                        List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(list));
        }
        target -= root.val;
        pathSum(root.left, target, result, list);
        pathSum(root.right, target, result, list);
        list.remove(list.size() - 1);
    }
}