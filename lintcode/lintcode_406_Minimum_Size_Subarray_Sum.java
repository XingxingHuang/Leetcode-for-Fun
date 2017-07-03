// @Author: Xingxing Huang
// Time Comlexity: O(n)
// http://www.lintcode.com/en/problem/minimum-size-subarray-sum/#
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start < nums.length) {
            // move right pointer and find the subarray larger than given value
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++; 
            }
            // now end point to the next value
            // when found, renew the ans and move the left pointer.
            if (sum >= s) {
                ans = Math.min(ans, end - start);
                sum -= nums[start];
            }
            start++;
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}