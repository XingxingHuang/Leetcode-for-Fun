/**
 *  注意larger的最后一个指针的处理。两种方法处理。
 */
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        // if (head == null) {
        //     return dummy.next;
        // }
        ListNode small = dummy;
        ListNode large = null;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                ListNode smallnext = small.next;
                small.next = head;
                small = small.next;
                small.next = smallnext;
            } else {
                if (small.next == null) {
                    large = small;
                }
                large.next = head;
                large = large.next;
                large.next = null;
            }
            head = next;
        }
        return dummy.next;
    }
}     

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode dummySmaller = new ListNode(-1);
        ListNode dummyLarger = new ListNode(-1);
        ListNode nextSmaller = dummySmaller;
        ListNode nextLarger = dummyLarger;
        while (head != null) {
            if (head.val < x) {
                nextSmaller.next = head;
                nextSmaller = nextSmaller.next;
            } else {
                nextLarger.next = head;
                nextLarger = nextLarger.next;
            }
            head = head.next;
        }
        nextLarger.next = null;
        nextSmaller.next = dummyLarger.next;
        return dummySmaller.next;
    }
}
