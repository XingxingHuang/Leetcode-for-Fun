 public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode helper = result;
        // get the size 
        int m = 0;
        while (head != null) {
            m ++;
            head = head.next;
        }
        // move to the node 
        if (m <= 1) {return null;}
        for (int i = 1; i < m - n + 1; i++) {
            helper = helper.next;
            
        }
        // delete the node 
        helper.next = helper.next.next;
        return result.next;
    }
}
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
        // delete the nth node, node.next;
        node.next  = node.next.next;
        return result.next;
    }
}
