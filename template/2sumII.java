// 本代码在旧的网站上才有.
// Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.
public class Solution {
    public int twoSum2(int[], nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                ans = ans + (right - left);
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}