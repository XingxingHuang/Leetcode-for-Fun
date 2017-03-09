/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode result = new ListNode(-1);
        ListNode cur = result.next;
        while (head != null) {
            result.next = head;
            head = head.next;
            result.next.next = cur;
            cur = result.next;
        }
        return result.next;
    }
}
