//http://www.lintcode.com/en/problem/add-two-numbers-ii/
// 两种解法
// 注意长度不一致时候的处理。

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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        int len1 = listLen(l1);
        int len2 = listLen(l2);
        if (len1 < len2) {
            int tmp = len1;
            len1 = len2;
            len2 = tmp;
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        // three step
        // 1. add extra
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        for (int i = 0; i < len1 - len2; i++) {
            dummy.next = new ListNode(l1.val);
            dummy = dummy.next;
            l1 = l1.next;
        }
        // 2. add directly
        while (l1 != null) {
            dummy.next = new ListNode(l1.val + l2.val);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 3. move carry
        boolean flag = true;
        while (flag) {  // 进行多次循环知道没有大于10的元素。
            flag = !flag;
            ListNode pre = res;
            ListNode cur = res.next;
            while (cur != null) {
                if (cur.val >= 10) {
                    pre.val += cur.val / 10;
                    cur.val = cur.val % 10;
                }
                if (pre.val >= 10) {
                    flag = true;
                }
                pre = pre.next;
                cur = cur.next;
            }
        }
        // return
        if (res.val == 0) {
            return res.next;
        } else {
            return res;
        }
    }  
    public int listLen(ListNode l) {
        int len = 0;
        while (l != null) {
            l = l.next;
            len++;
        }
        return len;
    }
}
// http://www.jiuzhang.com/solutions/add-two-numbers-ii/
// 可以先reserver 然后相加。
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        return reverse(addList1(l1, l2));
    }  
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private ListNode addList1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            tail.next = new ListNode((l1.val + l2.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + l2.val + carry) / 10;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            tail.next = new ListNode((l1.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + carry) / 10;
            
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            tail = tail.next;
            carry = (l2.val + carry) / 10;
            
            l2 = l2.next;
        }
        
        while (carry != 0) {
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry = carry / 10;
        }
        
        return dummy.next;
    }
}