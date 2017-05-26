// http://www.lintcode.com/en/problem/maximum-subarray/
// 简单题目。快速解决

// 糟糕解法
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            max = nums[i] > max ? nums[i]: max;
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] > max) {
                    max = nums[i] - nums[j];
                }
            }
        }
        return max;
    }
}

// O(n)解法
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}

// 如果前面的和小于0的话，就不需要前面的部分。
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}