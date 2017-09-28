class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }
        int[] res = new int[]{0, 0};
        // Get its last set bit
        diff &= -diff;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0)
                res[0] ^= nums[i];
            else 
                res[1] ^= nums[i];
        }
        return res;
    }
}