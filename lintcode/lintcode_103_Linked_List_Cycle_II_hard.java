/** https://www.lintcode.com/en/problem/linked-list-cycle-ii
 * 证明方法：
 * 
 * [1] 用快慢指针可以判断出是否有环。这时候他们走的距离分别是
 * s = k + n*l + d   
 * f = k + m*l + d = 2k + 2n*l + 2d
 * 其中k为到入环点的距离，l为周长，d为环中相遇点到入环点距离。
 * ->  k + d = (m - 2n)*l;
 * 
 * [2] 这时候让快指针重新从起点开始一步步移动。
 * 在移动k + d 步数之后，到达[1]中的相遇点，这时候慢指针也到达相同点。
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) 
                break;
        }
        // 注意这里容易出错。集中边界情况
        if (head == null || slow != fast) {
            return null;
        } else if (fast.next == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
