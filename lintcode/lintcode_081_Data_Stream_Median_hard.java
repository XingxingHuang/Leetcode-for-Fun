/**
 * https://www.lintcode.com/en/problem/data-stream-median/
 * 保持一个最小栈，一个最大栈，然后一个数存储中值即可。
 * 题目总的中值是奇数为中间值，偶数为中间两个值中左边一个。
 * 注意：
 *  中值在最大堆中的顶部元素
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null) {
            return null;
        }
        int m = nums.length;
        int[] res = new int[m];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //左最大
        PriorityQueue<Integer> maxHeap = 
                new PriorityQueue<Integer>(1, new midComparator()); //右最小
        for (int i = 0; i < m; i++) {
            // 初始化
            if (i == 0) {
                maxHeap.add(nums[i]);
                res[i] = nums[i];
                continue;
            }
            // 放入元素
            int x = maxHeap.peek();
            if (nums[i] > x) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            // 修正元素
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            res[i] = maxHeap.peek();
        }
        return res;
    }
    private class midComparator implements Comparator<Integer> {  
        @Override  
        public int compare(Integer x, Integer y) {  
            return y - x;  
        }  
    }
}

// http://www.jiuzhang.com/solutions/median-in-data-stream/
// 写法一 leetcode解
class MedianFinder {
    public PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }
};