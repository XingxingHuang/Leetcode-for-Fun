// @Author: Xingxing Huang
// 注意需要定义几个节点
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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode delete = new ListNode(-1);
        ListNode result = delete;
        delete.next = head;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            delete = delete.next;
            head = head.next;
        }
        delete.next = delete.next.next;
        return result.next;
    }
}
