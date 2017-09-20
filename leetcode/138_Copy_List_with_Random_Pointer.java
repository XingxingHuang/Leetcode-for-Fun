/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// 2017.08.16 XingxingHuang   time O(n)  space O(1)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        head = copynode(head);
        head = copyrand(head);
        return getnew(head);
    }
    public RandomListNode copynode(RandomListNode head) {
        RandomListNode root = head;
        while (head != null) {
            RandomListNode cur = new RandomListNode(head.label);
            cur.next = head.next;
            head.next = cur;
            head = head.next.next;
        }
        return root;
    }
    public RandomListNode copyrand(RandomListNode head) {
        RandomListNode root = head;
        while (head != null) {
            if (head.random != null) 
                head.next.random = head.random.next;
            head = head.next.next;
        }
        return root;
    }
    public RandomListNode getnew(RandomListNode head) {
        if (head == null) 
            return head;
        RandomListNode root = new RandomListNode(0);
        RandomListNode cur = root;
        while (head != null) {
            cur.next = head.next;
            cur = cur.next;
            head.next = head.next.next;
            head = head.next;
        }
        return root.next;
    }
}