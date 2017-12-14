/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 12.13 提取前面，提取后面，分别作为两个linkedlist，然后叠加在一起。
// https://discuss.leetcode.com/topic/13869/java-solution-with-3-steps
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}

// 12.13 提取前面，提取后面，分别作为两个linkedlist，然后叠加在一起。
// 错误的算法。顺序不对
class Solution {
    public void reorderList(ListNode head) {
        // 准备两个linkedlist
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode cur = head.next.next;
        p2.next = null;
        while (cur != null && cur.next != null) {
            // 改变第一个
            p1.next = cur;
            p1 = p1.next;
            // 改变第二个
            ListNode node = cur.next;
            cur = cur.next.next;
            node.next = p2;
            p2 = node;
        }
        if (cur != null) {
            p1.next = cur;
            p1 = p1.next;
        }
        p1.next = null;
        
        // // 测试代码
        // ListNode t = head;
        // while (t != null) {
        //     System.out.println(t.val);
        //     t = t.next;
        // }
        // return;
        
        // 合并两个linkedlist
        p1 = head;
        while (p2 != null) {
            System.out.println(p2.val);
            ListNode node = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = node;
        }
    }
}
