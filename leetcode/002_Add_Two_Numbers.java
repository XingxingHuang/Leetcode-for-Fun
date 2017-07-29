/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            head.next = node;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            head.next = node;
        }
        return res.next;
    }
}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}