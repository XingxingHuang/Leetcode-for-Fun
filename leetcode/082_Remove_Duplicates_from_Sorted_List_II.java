/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 12.12
// linkedlist题目，简单，但是需仔细想好再动笔
class Solution {
    public ListNode deleteDuplicates(ListNode head) {        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        
        while (node != null && node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                // 发现重复，将node移动到下一个不重复的位置（或者是null）
                ListNode tmp = node.next;
                while (tmp != null && tmp.val == node.next.val) 
                    tmp = tmp.next;
                node.next = tmp;
            } else {
                node = node.next;
            }
            // 小心边界条件
        }
        return dummy.next;
    }
}

// recursive method

public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    
    if (head.next != null && head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicates(head.next);
    } else {
        head.next = deleteDuplicates(head.next);
    }
    return head;
}