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
 * 
 * @author  Xingxing Huang  
 * @since   2017.04.17
 * @Time    O(n),   
 * @param   TreeNode, int
 * @return  int
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //int count = countTree(root);
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (k == 1) {
                return root.val;
            }
            k--;
            root = root.right;
        }
        return -1;
    }
}


// recursive method
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countTree(root.left);
        if (count == k - 1) {
            return root.val;
        }
        if (count > k - 1) {
            return kthSmallest(root.left, k);
        }
        if (count < k - 1) {
            return kthSmallest(root.right, k + 1 - count);
        }
        return 1;
    }
    
    public int countTree(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return 1 + countTree(n.left) + countTree(n.right);
    }
}

// https://discuss.leetcode.com/topic/17810/3-ways-implemented-in-java-python-binary-search-in-order-iterative-recursive
//Binary Search (dfs): most preferable
  public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

//DFS in-order recursive:
// better keep these two variables in a wrapper class
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }

//DFS in-order iterative:
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        
        while (root != null) {
            st.push(root);
            root = root.left;
        }
            
        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        
        return -1; // never hit if k is valid
    }
//
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        count = []
        self.helper(root, count)
        return count[k-1]
        
    def helper(self, node, count):
        if not node:
            return
        
        self.helper(node.left, count)
        count.append(node.val)
        self.helper(node.right, count)