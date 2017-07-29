/**
 * 画图。然后求解, 查看img目录下思路
 * @author  Xingxing Huang  
 * @since   2017.04.29
 * @Time    O(n),   
 * @param   ListNode
 * @return  ListNode
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseK(head, k);
    }
    
    public ListNode reverseK(ListNode head, int k) {
        // too short return
        int len = 0;
        ListNode fast = head;
        while(fast != null && len < k - 1) {
            len++;
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
        // start to reverse, 
        ListNode rev = fast.next;  // 记录k个节点后面的链表
        ListNode cur = head; // 记录现在需要添加的节点
        for (int i = 0; i < k; i++) {
            head = head.next;
            cur.next = (i == 0) ? reverseK(fast.next, k): rev;  // 将节点添加至结果前端。
            rev = cur;
            cur = head;
        }
        return rev;
    }
}


// 递归方法求解  几乎一样的思路
public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        // write code here
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        //此时cur为第k+1个节点
        if (count == k) {
            cur = inverse(cur,k);
            // 下面这个图展示了节点指向的顺序. 每次将头结点放置在cur节点之前。
            // head     tmp                   cur
            // [ 1 ] -> [ 2 ] -> .. [ n ] -> [ y ] -> ...
            // cur
            // [ 1 ] -> [ y ] -> ...
            // head
            // [ 2 ] -> .. -> [ n ]
            while(count-- >0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            //cur为翻转后的第一个节点
            head = cur;
        }
        return head;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseK(head, k);
    }
    
    public ListNode reverseK(ListNode head, int k) {
        // too short return
        int len = 0;
        ListNode fast = head;
        while(fast != null && len < k - 1) {
            len++;
            fast = fast.next;
        }
        if (fast == null) {return head;}
        // start to reverse 
        ListNode rev = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
            cur.next = (i == 0) ? reverseK(fast.next, k): rev;
            rev = cur;
            cur = head;
        }
        return rev;
    }
}