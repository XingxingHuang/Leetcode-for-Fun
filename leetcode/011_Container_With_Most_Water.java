// 09.15
// two pointer
class Solution {
    public int maxArea(int[] height) {
        int l = 0; 
        int r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) 
                l++;
            else 
                r--;
        }
        return area;
    }
}