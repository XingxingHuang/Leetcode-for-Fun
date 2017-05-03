// http://www.lintcode.com/en/problem/intersection-of-two-linked-lists/
// 相关问题： 如果有环的情况下应该如何解决。
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        }
        // 找长度
        int m = 0;
        int n = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
            m++;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
            n++;
        }
        // 先移动长链表
        if (m > n) {
            nodeA = headA;
            nodeB = headB;
        } else {
            nodeA = headB;
            nodeB = headA;
        }
        for (int i = 0; i < Math.abs(m - n); i++) {
            nodeA = nodeA.next;
        }
        // 寻找相同节点。
        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeA;
            } else {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }
        return null;
    }  
}