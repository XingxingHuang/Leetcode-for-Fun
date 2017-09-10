class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];  // the number with the height end with the element
        int[] height = new int[n]; // max length of increasing sequence at the element 
        
        for (int i = 0; i < n; ++i) {
            height[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (height[j] + 1 > height[i]) {
                        height[i] = height[j] + 1;
                        count[i] = count[j];
                    } else if (height[j] + 1 == height[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int maxH = 0;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (height[i] > maxH) {
                maxH = height[i];
                res = count[i];
            } else if (height[i] == maxH) {
                res += count[i];
            }
        }
        
        return res;
    }
}
