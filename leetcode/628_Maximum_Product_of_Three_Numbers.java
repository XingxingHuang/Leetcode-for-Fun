import java.util.*;


// 我的最初方法，排序之后多情况讨论
public class Solution {
    public int maximumProduct(int[] nums) {
        // 时间复杂度超过O(n)的都应该考虑先sort
        Arrays.sort(nums);
        for (int start = 0, end = nums.length - 1; start <= end; start++, end--) {
            int aux = nums[start];
            nums[start]=nums[end];
            nums[end]=aux;
        }
        // 找到0的起点终点。
        int start = nums.length;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                end = i;
                break;
            }
        }
        // 输出。
        if (nums.length - (end - start + 1) < 3|| start < 1) { // less number, or less positive.
            return 0;
        }
        int neg = nums[nums.length - 1] * nums[nums.length - 2]; // can be 0
        int pos = nums[0] * nums[1];
        return Math.max(neg * nums[0], pos * nums[2]);
        // if (neg >= pos || start <= 2) {
        //     return neg * nums[0];
        // } else {
        //     return pos * nums[2];
        // }
    }
}


// 代码简洁的方法
public class Solution {
    public int maximumProduct(int[] nums) {
        
         Arrays.sort(nums);
         //One of the Three Numbers is the maximum value in the array.

         int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
         int b = nums[0] * nums[1] * nums[nums.length - 1];
         return a > b ? a : b;
    }
}

// O(n)复杂度方法
public class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}