// 09.22
// the best solution has O(n)
// Use deque to store the index, but should be clever how to input and output number
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) 
            return new int[0];
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1)  // poll n out of range
                dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) // poll n lower than current
                dq.pollLast();
            dq.offer(i);
            if (i >= k - 1) 
                res[idx++] = nums[dq.peek()];
        }
        return res;   
    }
}