// 2017.07.23 
// @Author Xingxing Huang 

// 暴力解法  
public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int m = nums[j] - nums[i];
                int n = nums[j] + nums[i];
                for ( int k = j + 1; k < nums.length; k++) {
                    if (nums[k] >= n) 
                        break;
                    if (nums[k] > m) 
                        count++;
                }
            }
        }
        return count;
    }
}


// https://leetcode.com/problems/valid-triangle-number/#/solution
// O(n^2 logn) 
public class Solution {
    int binarySearch(int nums[], int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }
}

// O(n^2)
public class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}