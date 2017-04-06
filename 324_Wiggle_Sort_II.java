/** leetcode, find the kth largest. 
 *  https://leetcode.com/problems/kth-largest-element-in-an-array/
 *  这里与waggle sort I中不同的是，这里要求reorder后相临的元素不能相等。这会显著提高算法复杂度。
 *  这题的思路是先用quick sort类似的方法找到数组median值
 *  第二部可以很简单地将两部分交叉和在一起，怎么只用O(1)的空间完成交叉是一个难点
 *  但是这里采用index mapping的方法，更加简洁，具体查看solution的第一个帖子，有详细演示。
 *  @Author: Xingxing Huang
 *  @Date: 2017.04.06
 *  @Time: O(n)
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int median = findKth(nums, (len + 1) / 2, 0, len - 1);
        int i = 0; //循环变量
        int left = 0; 
        int right = len - 1;
        while (i <= right) {
            if (nums[newIndex(i, len)] > median) {
                swap(nums, newIndex(left++, len), newIndex(i++, len));
            }
            else if (nums[newIndex(i, len)] < median) {
                swap(nums, newIndex(right--, len), newIndex(i, len));
            }
            else {
                i++;
            }
        }
    }
    private int newIndex(int index, int n) {
        // (n|1) return n+1 is even, return n if odd
        return (1 + 2*index) % (n | 1);
    }
    
    public int findKth(int[] nums, int pos, int low, int high) {
        // simliar with the quick sort program. Now return if the nums[pos] is the kth largest
        int start = low;
        int end = high;
        int pivot = nums[pos];
        while (start <= end) {
            while (nums[start] < pivot) {
                start ++;
            } 
            while (nums[end] > pivot) {
                end --;
            }
            if (start == pos && end == pos) {
                return nums[pos];
            } 
            if (start <= end) {
                swap(nums, start, end);
                start ++;
                end --;
            }
        }
        if (start <= pos) {
            return findKth(nums, pos, start, high);
        } 
        return findKth(nums, pos, low, end);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}