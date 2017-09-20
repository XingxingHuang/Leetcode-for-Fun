/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode L = new ListNode(0);
        ListNode head = L;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                L.next = l2;
                l2 = l2.next;
            } else if (l2 == null || l1.val <= l2.val) {
                L.next = l1;
                l1 = l1.next;
            } else {
                L.next = l2;
                l2 = l2.next;
            }
            L = L.next;
        }
        return head.next;
    }
}

// recursive
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}