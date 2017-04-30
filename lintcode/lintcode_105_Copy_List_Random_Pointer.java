/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// http://blog.csdn.net/guoziqing506/article/details/51376619
// http://www.jiuzhang.com/solutions/copy-list-with-random-pointer/
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode node = new RandomListNode(0);
        while (head != null) {
            // add the next node
            if (map.containsKey(head)) {
                node = map.get(head);
            } else {
                node = new RandomListNode(head.label);
                map.put(head, node);
            }
            pre.next = node;
            // add the random node
            // attention: check the next point is null
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    node.random = map.get(head.random);
                } else {
                    node.random = new RandomListNode(head.random.label);
                    map.put(head.random, node.random);
                }
            }
            // point to the next value
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }
}