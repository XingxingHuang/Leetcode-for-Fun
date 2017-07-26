// @Author: 黄xing
// https://github.com/XingxingHuang
// Time: 套用标准二分法模板求解，O(log N) 
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[end]) {
                return nums[start];
            } else if (nums[start] > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
}