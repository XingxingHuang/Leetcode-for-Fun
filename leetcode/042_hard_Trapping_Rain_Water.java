// 09.15
// two pointer 
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        
        int l = 0;
        int r = height.length - 1;
        // while (l < r && height[l] < height[l + 1]) l++;  // no need
        // while (l < r && height[r - 1] > height[r]) r--;
        
        int area = 0;
        int start = height[l];
        int end = height[r];
        while (l <= r) {
            if (start < end) {
                area = area + ((start - height[l] > 0) ? start - height[l] : 0);
                start = Math.max(start, height[l]);
                l++;
            } else {
                area = area + ((end - height[r] > 0) ? end - height[r] : 0);
                end = Math.max(end, height[r]);
                r--;
            }
        }
        return area;
    }
}


class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) 
            return 0;
        
        int l = 0;
        int r = height.length - 1;
        int start = height[l];
        int end = height[r];
        int area = 0;
        while (l <= r) {
            start = Math.max(start, height[l]);
            end = Math.max(end, height[r]);
            if (start < end) {
                area += start - height[l];
                l++;
            } else {
                area += end - height[r];
                r--;
            }
        }
        return area;
    }
}


// stack solution 
// https://discuss.leetcode.com/topic/4939/a-stack-based-solution-for-reference-inspired-by-histogram