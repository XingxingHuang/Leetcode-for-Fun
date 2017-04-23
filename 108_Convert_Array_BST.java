/**
 * 中序遍历的反序列化。
 * @author  Xingxing Huang  
 * @since   2017.04.23
 * @Time    O(n),   
 * @param   int[]
 * @return  TreeNode
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } 
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);
        return node;
    }
}