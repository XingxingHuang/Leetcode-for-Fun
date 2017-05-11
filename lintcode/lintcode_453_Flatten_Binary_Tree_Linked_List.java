// https://www.lintcode.com/en/problem/flatten-binary-tree-to-linked-list/
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        helper(root);
    }
    public TreeNode helper(TreeNode root) {
        // 递归中值条件, 注意两个递归终止条件
        if (root.left == null && root.right != null) {
            return helper(root.right);
        }
        if (root.right == null) {
            if (root.left == null) {
                return root;
            }
            TreeNode last = helper(root.left);
            root.right = root.left;
            root.left = null;
            return last;
        }
        // 开始递归
        TreeNode last = helper(root.left);
        last.right = root.right;
        root.right = root.left;
        root.left = null;
        // 递归返回结果
        return helper(last.right);
    }
}



// 查看九章的三种解法 采用全局last node
// 九章的解法三个解法很不错。  第一种解法用到全局变量技巧，第二种解法跟第一种是头递归和尾递归版本，第三种解法是递归改非递归。
//  https://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/
// Version 1: Traverse
public class Solution {
    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode == null) {
            lastNode = root;
        } else {
            lastNode.left = null;
            lastNode.right = root;
        }
        
        // 先保存right节点，防止丢失，然后将左边，右边分别加入last节点的后继。
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}

// version 2: Divide & Conquer
// 分治思想就不需要全局变量了。
// divide and conquer老师说，一般都是要返回一个类型的东西.所以不会是void，并且每个helper()调用是平行的。
// traverse 里面经常先 left,  再right,顺序是会影响的，例如prev node
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast != null) {
            return rightLast;
        }
        
        if (leftLast != null) {
            return leftLast;
        }
        
        return root;
    }
}

// 一个比较容易理解的版本，无全局变量。
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}    
    
// 全局变量简化版本
// 头递归，prev表示的是上一次递归结束后的头结点。
public class Solution {    
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// 对比九章算法的全局变量版本， preorder
// 上面全局变量简化版本，postorder

// 这是 preorder 的写法， 它先写怎么处理lastnode的左右链接，然后更新lastnode,然后再对左右做操作
// 这个是postorder写法，先对右，左操作，再对lastnode操作

// preorder 的时候，是从上往下，从左往右
// postorder的时候，它让从下往上，从右往左