// http://www.lintcode.com/en/problem/add-two-numbers/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode res = new ListNode(0);
        return helper(res, l1, l2);
    }
    
    public ListNode helper(ListNode dummy, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            if (dummy.val == 0) {
                return null;
            } else {
                return dummy;
            }
        } else if (l1 == null) {
            int sum = l2.val + dummy.val;
            dummy.val = sum % 10;
            dummy.next = new ListNode(sum / 10);
            dummy.next = helper(dummy.next, l1, l2.next);
        } else if (l2 == null) {
            int sum = l1.val + dummy.val;
            dummy.val = sum % 10;
            dummy.next = new ListNode(sum / 10);
            dummy.next = helper(dummy.next, l1.next, l2);
        } else {
            int sum = l1.val + l2.val + dummy.val;
            dummy.val = sum % 10;
            dummy.next = new ListNode(sum / 10);
            dummy.next = helper(dummy.next, l1.next, l2.next);
        }
        return dummy;
    } 
}

// 九章解法
// http://www.jiuzhang.com/solutions/add-two-numbers/
public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
            
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
}