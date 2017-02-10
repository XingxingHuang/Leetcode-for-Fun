/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode node = result;
        ListNode helper = head;
        while (n > 0) {
            helper = helper.next;
            n--;
        }
        while (helper != null) {
            node = node.next;
            helper = helper.next;
        }
        // ignore the helper.next;
        node.next  = node.next.next;
        return result.next;
    }
}