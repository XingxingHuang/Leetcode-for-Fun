/**
 * https://www.lintcode.com/en/problem/sliding-window-maximum/
 * 注意先放入k -1 个元素。双端队列
 * 
 * 从前方放入新元素，先弹出较小的元素，再放入新元素。
 * 从后方弹出过期元素。
 * 从后方取出windows中的最大值放入结果中。
 * 
 * leetcode 的解答：
 * https://leetcode.com/problems/sliding-window-maximum/#/solutions
 * 九章的答案，采用了多个函数：
 * http://www.jiuzhang.com/solutions/sliding-window-maximum/
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        // 先放入 k-1 个元素 
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && nums[queue.peekFirst()] < nums[i]) {
                queue.pollFirst();
            }
            queue.addFirst(i);
        }
        // 循环判断
        for (int i = k - 1; i < nums.length; i++) {
            // remove nums out of range
            if (!queue.isEmpty() && i - queue.peekLast() >= k) {                 queue.pollLast();
            }
            // remove smaller useless nums
            while (!queue.isEmpty() && nums[queue.peekFirst()] < nums[i]) {
                queue.pollFirst();
            }
            // add nums
            queue.addFirst(i);
            res.add(nums[queue.peekLast()]);
        }
        return res;
    }
}




// leetcode 
// 队列进出顺序与我的代码相反。
public class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {     
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
