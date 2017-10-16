/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 10.15 easy linkedlist
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(0);
        ListNode higher = new ListNode(0);
        ListNode l = lower;
        ListNode r = higher;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        l.next = higher.next;
        r.next = null;
        return lower.next;
    }
}