// 10.13  注意置换的顺序，然后array操作即可
// 123 > 132 > 213 > 231 > 312 > 321
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) 
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) 
            i--;
        if (i < 0) { 
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // example: 127654 > 142567
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) 
            j--;
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) 
            swap(nums, start++, end--);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}
