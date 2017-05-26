// https://www.lintcode.com/en/problem/maximum-product-subarray/
// corner case 数组中包含 0 ???


// 我的代码，初始值设置为0，有些麻烦
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = 0;
        int min = 0;
        int curmax = max; // 要用curmax
        int curmin = min;
        int globalmax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                curmax = Math.max(nums[i], max * nums[i]);
                curmin = Math.min(nums[i], min * nums[i]);
            } else {
                curmax = Math.max(nums[i], min * nums[i]);
                curmin = Math.min(nums[i], max * nums[i]);
            }
            max = curmax;
            min = curmin;
            if (max == 0) {// 处理只包含一个负数情况
                globalmax = Math.max(globalmax, min);
            } else {
                globalmax = Math.max(globalmax, max);
            }
        }
        return globalmax;
    }
}

// XF的代码
public class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int curmax = 1;
        int curmin = 1;
        int globalmax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                curmax = Math.max(nums[i], nums[i] * max);
                curmin = Math.min(nums[i], nums[i] * min);
            } else {
                curmax = Math.max(nums[i], nums[i] * min);
                curmin = Math.min(nums[i], nums[i] * max);
            }
            max = curmax;
            min = curmin;
            globalmax = Math.max(globalmax, max);
        }
        return globalmax;
    }
}

// 九章代码
// 初始化的时候直接设置为第一个元素的值。并且存储所有的max和min
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length]; 
        int[] min = new int[nums.length];
        
        min[0] = max[0] = nums[0]; // 这时候并没有考虑正负的情况
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            
            result = Math.max(result, max[i]);
        }
        
        return result;
    }
}