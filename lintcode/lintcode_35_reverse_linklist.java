// @Author: Xingxing Huang
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */

// 只维护两个指针
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}

// 采用 dummy node 方法 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */    
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
            // ListNode next1 = dummy.next;
            // dummy.next = head;
            // ListNode next2 = head.next;
            // head.next = next1;
            // head = next2;
        }
        return dummy.next;
    }
}
 
 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */    
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode res = head;
        while (head.next != null) {
            ListNode next = head.next.next;
            head.next.next = res;
            res = head.next;
            head.next = next;
        }
        return res;
    }
}
 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode result = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            head.next = result.next;
            result.next = head;
            head = temp;
        }
        return result.next;
    }
}

