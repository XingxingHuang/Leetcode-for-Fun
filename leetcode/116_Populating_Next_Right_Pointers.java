/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// 12.12 重新练习
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while (level_start != null){
            TreeLinkNode cur = level_start;
            while (cur != null){
                // 连接左右子树
                if(cur.left != null) 
                    cur.left.next = cur.right;
                // 连接右子树和顺延的下一个
                if(cur.right != null && cur.next != null) 
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }
}