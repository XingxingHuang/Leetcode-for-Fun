/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 找到第m个元素的前一个节点，存储翻转后m-n的最后一个节点，即节点m。
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode last = pre.next; // save for later. 
        ListNode cur = pre.next;
        for (int i = 0; i <= n - m; i++) {
            ListNode node = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = node;
        }
        last.next = cur;
        return dummy.next;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) {
            pre = pre.next;
        }
        
        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed
        
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        
        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        
        return dummy.next;
        
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        ListNode p = cur;  // cur 为需要转的第一个节点。
        cur = cur.next;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = p;
            p = cur;
            cur = temp;
        }
        prev.next.next = cur;
        prev.next = p;
        return dummy.next;
    }
}


// 
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        // find m, move to pre of m
        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }
        ListNode nodem = cur.next;
        //find n, move to pre of n
        ListNode noden = cur;
        for (int i = 0; i < n - m + 1; i++) {
            noden = noden.next;
        }
        cur.next = noden.next;
        noden.next = null;
        // reverse m,  cur, nodem
        while (nodem != null) {
            ListNode tmp = nodem;
            nodem = nodem.next;
            tmp.next = cur.next;
            cur.next = tmp;
        }
        return dummy.next;
    }
}