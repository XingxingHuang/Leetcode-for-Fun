// http://www.lintcode.com/en/problem/second-max-of-array/

public class Solution {
    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        /* your code */
        if (nums == null || nums.length <= 1) {
            return Integer.MIN_VALUE;
        }
        int max1 = nums[0];
        int max2 = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max2) {
                if (nums[i] > max1) {
                    max2 = max1;
                    max1 = nums[i];
                } else {
                    max2 = nums[i];
                }
            }
        }
        return max2;
    }
}


// 采用优先队列的解法
public class Solution {
    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        /* your code */
        if (nums == null || nums.length <= 1) {
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(2);
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < 2 || heap.peek() < nums[i]) {
                if (heap.size() == 2) {
                    heap.poll();
                }
                heap.add(nums[i]);
            }
        }
        return heap.poll();
    }
}