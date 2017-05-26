// https://www.lintcode.com/en/problem/maximum-subarray-ii/
// 分别从前往后，从后往前, 计算最大subarray
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        int[] leftmax = new int[size];
        int[] rightmax = new int[size];
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
            leftmax[i] = max;
        }
        max = Integer.MIN_VALUE;
        sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
            rightmax[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, leftmax[i] + rightmax[i + 1]);
        }
        return max;
    }
}

