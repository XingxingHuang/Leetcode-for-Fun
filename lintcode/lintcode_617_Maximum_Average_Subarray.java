// http://www.lintcode.com/en/problem/maximum-average-subarray/
/** 
 * 普通方法的时间复杂度为O(n^2)，可以采用二分法优化
 * 
 * 看到题目连续求和，应该想到最小和的求解是O(n)，然后可以联想到二分法。
 * 
 * 一个数组的子数组的最大平均数一定在数组的最大值和最小值之间，所以二分法的第一步限定average位于[min,max]之中。
 * 整个数组减去median，如果存在相邻k个以上数组和大于0，那么average应该大于median。
 * 关键是如何快速判断是否存在相邻k以上数组大于0的方法，时间复杂度为O(n)、
 */
 
public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (max - min > 1.e-6) {
            double mid = (max + min) / 2.;
            if (valid(nums, mid, k)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }
    // 判断是否存在k个连续的数组和满足要求。用连续和的算法
    private boolean valid(int[] nums, double mid, int k) {
        double[] sum = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i] - mid;
        }        
        // System.out.println(Arrays.toString(sum));
        double minsum = 0;
        for (int i = k; i < sum.length; i++) {
            minsum = Math.min(sum[i - k], minsum);
            if (sum[i] - minsum >= 0) {
                return true;
            }
        }
        return false;
    }
}

// 九章答案
// http://www.jiuzhang.com/solution/maximum-average-subarray/
public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < l)
                l = nums[i];
            if (nums[i] > r)
                r = nums[i];
        }
        
       
        while (r - l >= 1e-6) {
            double mid = (l + r) / 2.0;

            if (check_valid(nums, mid, k)) {
                l = mid;
            }
            else {
                r = mid;
            }
        }

        return l;
    }
    
    private boolean check_valid(int nums[], double mid, int k) {
        int n = nums.length;
        double min_pre = 0;
        double[] sum = new double[n + 1];
        sum[0] = 0; 
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >= k && sum[i] - min_pre >= 0) {
                return true;
            }
            if (i >= k)
                min_pre = Math.min(min_pre, sum[i - k + 1]);
        }
        return false;
    }
}

