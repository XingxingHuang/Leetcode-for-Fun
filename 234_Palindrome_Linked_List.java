/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode rev = null;
        while (fast != null && fast.next != null) {
            // slow and fast pointer
            slow = slow.next;
            fast = fast.next.next;
            // reversed pointer
            head.next = rev;
            rev = head;
            head = slow;
        }
        // consider the odd situation
        if (fast != null) { slow = slow.next;}
        // compare the two list
        while(slow != null) {
            if (slow.val != rev.val) {return false;}
            slow = slow.next;
            rev = rev.next;
        }
        return true;
    }
}