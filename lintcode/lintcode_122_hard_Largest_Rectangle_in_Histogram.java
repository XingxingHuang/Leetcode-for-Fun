// http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while (i <= height.length){
            // 必须计算到height.length
            int curh = (i == height.length) ? -1 : height[i]; 
            while (!stack.isEmpty() && curh <= height[stack.peek()]) {
                // 如果下一个柱子较矮，那么开始计算面积，i不变，从stack中取元素。
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(max, h * w);
            } 
            stack.push(i++);
        }
        return max;
    }
}



// 使用时间稍长
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while (i <= height.length){
            // 必须计算到height.length
            int curh = (i == height.length) ? -1 : height[i]; 
            if (stack.isEmpty() || curh >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // 如果下一个柱子较矮，那么开始计算面积，i不变，从stack中取元素。
                int t = stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, height[t] * i);
                } else {
                    max = Math.max(max, height[t] * (i - stack.peek() - 1));
                }
            } 
        }
        return max;
    }
}



// 九章答案
// http://www.jiuzhang.com/solution/largest-rectangle-in-histogram/

public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
}

