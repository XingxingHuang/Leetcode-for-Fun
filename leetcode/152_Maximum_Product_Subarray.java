// 12.21 注意正负号 和 0
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        for (int i = 1, imax = res, imin = res; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            imax = Math.max(nums[i]*imax, nums[i]); 
            imin = Math.min(nums[i]*imin, nums[i]);
            res = Math.max(res, imax);
        }
        return res;
    }
}