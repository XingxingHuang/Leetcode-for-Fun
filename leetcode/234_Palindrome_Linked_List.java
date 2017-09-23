/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 在快慢指针时候就进行前面列表的翻转
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


// 09.22
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next; 
            slow = slow.next;  // stop at the mid, (odd should slow.next)
        }
        // reverse second part
        ListNode dummy = new ListNode(0);
        if (fast == null) {
            dummy.next = slow;
        } else {
            dummy = slow;
        }
        ListNode cur = dummy.next;
        dummy.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }
        // check palindrome
        cur = dummy.next;
        ListNode curhead = head;
        while (cur != null) {
            if (cur.val != curhead.val) return false;
            cur = cur.next;
            curhead = curhead.next;
        }
        return true;
    }
}