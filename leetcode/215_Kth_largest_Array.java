/** @Author: Xingxing Huang
 *  @Time: O(nlogn) -> O(nlogk) -> O(n)
 *  @Date: 2017.04.06 revised
 *  最简单的方法是直接sort的方法，时间复杂度O(nlogn)
 *  如果只用一个k大小的堆存储数组，时间复杂度为O(nlogn)
 *  采用快排的思想，时间复杂度可以下降为O(n), 最坏情况O(n^2)
 *  可以shuffle输入，这样时间复杂度就可以是O(n).
 *  注意: 下面的方法尝试采用一个固定位置的pivot
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {return Integer.MAX_VALUE;}
        if (nums.length == 1) {return nums[0];}
        return findKth(nums, nums.length - k, 0, nums.length - 1);
    }
    
    public int findKth(int[] nums, int pos, int low, int high) {
        // simliar with the quick sort program. Now return if the nums[pos] is the kth largest
        // System.out.println(Arrays.toString(nums) + "  " +Integer.toString(low) + "   "+Integer.toString(high));
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
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start ++;
                end --;
            }
        }
        if (start <= pos) {
            return findKth(nums, pos, start, high);
        } 
        return findKth(nums, pos, low, end);
    }
}