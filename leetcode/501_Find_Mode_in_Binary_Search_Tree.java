/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//2017.08.25  中序遍历为递增序列，连续判断重复的数字多少即可。
// 这里需要遍历两次，第一次取得最大的重复次数，第二次查看重复次数最多的元素
class Solution {
    private int max = 0;
    private Integer pre;
    private ArrayList<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traverse(root, 0);
        // System.out.println(max);
        pre = null;
        traverse2(root, 0);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) 
            ans[i] = res.get(i);
        return ans;
    }
    private int traverse(TreeNode root, int count) {
        if (root == null) return 0;
        if (root.left != null) 
            count = traverse(root.left, count);
        if (pre != null && pre == root.val) {
            count++;
        } else {
            count = 1;
            pre = root.val;
        }
        max = Math.max(max, count);
        if (root.right != null) 
            count = traverse(root.right, count);
        return count;
    }    
    
    private int traverse2(TreeNode root, int count) {
        if (root == null) return 0;
        if (root.left != null) 
            count = traverse2(root.left, count);
        if (pre != null && pre == root.val) {
            count++;
        } else {
            count = 1;
            pre = root.val;
        }
        if (count == max) 
            res.add(root.val);
        if (root.right != null) 
            count = traverse2(root.right, count);
        return count;
    }        
}



// https://discuss.leetcode.com/topic/77335/proper-o-1-space
public class Solution {
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    
    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}


    private void inorder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }