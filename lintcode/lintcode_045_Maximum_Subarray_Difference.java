// https://www.lintcode.com/en/problem/maximum-subarray-difference/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] leftmax = new int[n];
        int[] leftmin = new int[n];
        int[] rightmax = new int[n];
        int[] rightmin = new int[n];
        
        // left
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int summax = 0;
        int summin = 0;
        for (int i = 0; i < n; i++) {
            // max
            summax += nums[i];
            max = Math.max(summax, max);
            summax = Math.max(summax, 0);// reset
            leftmax[i]= max;
            // min
            summin += nums[i];
            min = Math.min(summin, min);
            summin = Math.min(summin, 0);// reset
            leftmin[i] = min;
        }
        // right
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        summax = 0;
        summin = 0;
        int max_sum = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) { // 请不要求反了。
            // max
            summax += nums[i];
            max = Math.max(summax, max);
            summax = Math.max(summax, 0);// reset
            rightmax[i]= max;
            // // min
            // summin += nums[i];
            // min = Math.min(summin, min);
            // summin = Math.min(summin, 0);// reset
            // rightmin[i] = min;
            // // another method, check I
            sum += nums[i];
            min = Math.min(min, sum - max_sum);
            max_sum = Math.max(max_sum, sum);
            rightmin[i] = min;
        }
        // find min from left-right or right-left.
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, Math.abs(leftmax[i] - rightmin[i + 1]));
            max = Math.max(max, Math.abs(leftmin[i] - rightmax[i + 1]));
        }
        return max;
    }
}

