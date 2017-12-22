/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 12.21
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        // push the left nodes of the right node.
        TreeNode tmpNode = node.right; 
        while (tmpNode != null) {
            stack.push(tmpNode);
            tmpNode = tmpNode.left;
        }
        return node.val;
    }
}

    // // 可以用这个代码替换循环
    // private void pushAll(TreeNode node) {
    //     for (; node != null; stack.push(node), node = node.left);
    // }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */