/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> d1 = new Stack<Integer>();
        Stack<Integer> d2 = new Stack<Integer>();
        ListNode node = null;
        while (l1 != null) {
            d1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            d2.push(l2.val);
            l2 = l2.next;
        }
        
        int sign = 0;
        while (!d1.isEmpty() || !d2.isEmpty() || sign != 0) { // check the sign
            int temp1 = d1.isEmpty() ? 0 : d1.pop(); 
            int temp2 = d2.isEmpty() ? 0 : d2.pop(); 
            int sum = sign + temp1 + temp2;
            sign = sum / 10;
            ListNode newnode = new ListNode(sum % 10);
            newnode.next = node;
            node = newnode;
        }
        return node;
    }
}
