/**
 * 简单DP 思想，先求和，并同时找最大最小值。
 * 注意参数顺序，需要画图分析出来，然后再谢代码
 * @athor  Xingxing Huang
 * @since  2017.04.14
 * @Time   O(n), 
 * @param
 * @return 
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // 定义初始状态
        int min = 0; 
        int max = nums[0];
        int sum = nums[0];
        // 递归求解
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(sum, min);
            sum += nums[i];
            // 分解为小问题
            max = Math.max(sum - min, max);
        }
        return max;
    }
}
