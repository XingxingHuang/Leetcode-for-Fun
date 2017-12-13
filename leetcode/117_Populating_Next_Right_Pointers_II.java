/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// 12.12  很好的练习题
// 这个dummy节省了很多时间。 注意思考和下面代码的区别。实际上是用dummy节省一个节点空间
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }
}


public class Solution {
    
    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
    }
}



/// I give up this method
// public class Solution {
//     public void connect(TreeLinkNode root) {
//         if (root == null) 
//             return null;
//         TreeNode leftmost = root;
//         while (leftmost != null) {
//             // 查找最左边的开端
//             while(leftmost != null && leftmost.left == null && leftmost.right == null) 
//                 leftmost = leftmost.next;
//             if (leftmost == null) 
//                 return;
//             TreeNode cur = leftmost;
//             if (leftmost.left != null) {
//                 leftmost = leftmost.left;
//             } else {
//                 leftmost = leftmost.right;
//             }
//             // 开始设置下一层
//             if (cur.left != null) {
//                 TreeNode node = cur.left;
//                 if (cur.right != null) {
//                     node.next = cur.right;
//                     node = node.next;
//                 }
//             } else {
//                 node = cur.right;
//             }
//             // too much complicated
//             // ......
//         }
//     }
// }