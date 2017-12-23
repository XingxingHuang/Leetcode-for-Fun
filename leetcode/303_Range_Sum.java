/**
 * 可以看做最简单的DP思想，但是corner case 需要好好考虑
 * @athor  Xingxing Huang
 * @since  2017.04.14
 * @Time   O(n), 
 * @param
 * @return 
 */
public class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i <= 0) {
            return nums[j];
        }
        if (j >= nums.length) {
            return nums[nums.length - 1];
        }
        return nums[j] - nums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */


// 12.21
class NumArray {
    private int[] sums;
    
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) { 
            sums = new int[0];
            return;
        }
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) 
            sums[i] = sums[i - 1] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        if (i == 0)
            return sums[j];
        else
            return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */