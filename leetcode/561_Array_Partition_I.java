// 10.10 math trick
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length/2; i++) {
            sum += nums[i*2];
        }
        return sum;
    }
}