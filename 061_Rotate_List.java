/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {return head;}
        // get the size, get the cycle linklist
        int n = 1;
        ListNode test = head;
        while (test.next != null) { 
            n++;
            test = test.next;
        }
        test.next = head;
        
        // move the linklist 
        for (int i = 1; i < n - k % n ; i++) {
            head = head.next;
        }
        ListNode last = head;
        head = head.next;
        last.next = null;
        return head;
    }
}