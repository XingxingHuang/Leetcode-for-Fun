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