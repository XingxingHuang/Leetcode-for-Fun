// https://discuss.leetcode.com/topic/35976/7-lines-easy-java-solution
// 神奇的解法，根据outdegree 和 indegree的关系。
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0)
                return false;
            if (!node.equals("#"))
                diff += 2;
        }
        return diff == 0;
    }
}

// https://discuss.leetcode.com/topic/35973/java-intuitive-22ms-solution-with-stack
public class Solution {
    public boolean isValidSerialization(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}

// 每日一群, 先序遍历整个数组，看是否能遍历结束
public class Solution {
    public  boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String n : nodes) 
            queue.offer(n);
        boolean res = traversal(queue);
        return res && queue.isEmpty();
    }
    private boolean traversal(Queue<String> queue) {
        if (queue.isEmpty()) 
            return false;
        if ("#".equals(queue.poll()))
            return true;
        boolean l = traversal(queue);
        boolean r = traversal(queue);
        return l && r;      
    }
}