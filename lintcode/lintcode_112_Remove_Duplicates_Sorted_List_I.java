// http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/
// 注意写程序的时候考虑清楚，没能一遍过。
// 这里可以不用dummy node，dummy node的使用情况是这个头结点不一定使用的情况。

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     /**
//      * @param ListNode head is the head of the linked list
//      * @return: ListNode head of linked list
//      */
//     public static ListNode deleteDuplicates(ListNode head) { 
//         // write your code here
//         if (head == null) {
//             return null;
//         }
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         while (head.next != null) {
//             if (head.val == head.next.val) {
//                 head.next = head.next.next;
//             } else {
//                 head = head.next;
//             }
//         }
//         return dummy.next;
//     }  
// }

public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return node;
    }  
}