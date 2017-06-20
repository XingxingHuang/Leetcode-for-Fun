// http://www.lintcode.com/en/problem/trapping-rain-water/
// two pointers, two values。
// 思路没有理清楚。写代码比较混乱
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int tot = 0;
        if (heights == null || heights.length <= 2) {
            return tot;
        }
        int i = 0;
        int j = heights.length - 1;
        int start = 0;
        int end = 0;
        while (heights[i] >= start && i < j) {
            start = heights[i];
            i++;
        } 
        while (heights[j] >= end && i < j) {
            end = heights[j];
            j--;
        }
        while (i <= j) { // 注意等于号
            // calculate from the beginning 
            if (start <= end) {
                if (heights[i] <= start) {
                    tot += start - heights[i];
                } else {
                    start = heights[i];
                }
                i++;
            } else {
            // calculate from the end 
                if (heights[j] <= end) {
                    tot += end - heights[j];
                } else {
                    end = heights[j];
                }
                j--;
            }
        }
        return tot;
    }
}

// 九章
// 第一种方法为双指针，与我的代码类似
// 第二种方法为用从前到后，和从后到前两次遍历记录maxheight 数组，来记录可能到达的两边最大值。
// http://www.jiuzhang.com/solution/trapping-rain-water/
//Version 0: Two pointer
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int left = 0, right = heights.length - 1; 
        int res = 0;
        if(left >= right)
            return res;
        int leftheight = heights[left];
        int rightheight = heights[right];
        while(left < right) {
            if(leftheight < rightheight) {
                left ++;
                if(leftheight > heights[left]) {
                    res += (leftheight - heights[left]);
                } else {
                    leftheight = heights[left];
                }
            } else {
                right --;
                if(rightheight > heights[right]) {
                    res += (rightheight - heights[right]);
                } else {
                    rightheight = heights[right];
                }
            }
        }
        return res;
    }
}      

// Version 1
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        int[] maxHeights = new int[heights.length + 1];
        maxHeights[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
        }
        
        int max = 0, area = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            area += Math.min(max, maxHeights[i]) > heights[i]
                    ? Math.min(max, maxHeights[i]) - heights[i]
                    : 0;
            max = Math.max(max, heights[i]);
        }
        
        return area;
    }
}
