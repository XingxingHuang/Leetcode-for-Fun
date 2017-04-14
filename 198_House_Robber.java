/**
 * DP问题，每次结果可以分解为 (i-2最优结果+i), 或者 (i - 1最优结果)
 * @athor  Xingxing Huang
 * @since  2017.04.14
 * @Time   O(n), 
 * @param  array
 * @return int, maximum money
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }
}
