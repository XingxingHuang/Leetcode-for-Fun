// http://www.lintcode.com/en/problem/maximal-rectangle/
// 九章答案：
// http://www.jiuzhang.com/solution/maximal-rectangle/
public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];
 
        // 按行累加。
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!matrix[i][j]) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        // 计算每一行的最大面积
        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
 
    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
    
        int i = 0;
        int max = 0;
     
        while (i < height.length) {
            // 如果栈为空，或新高度大于栈顶，那么入栈。并且计算下一个元素
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            // 如果栈空，则值为height[t],
            // 如果新高度较小，计算长方形值。注意没有i++,  
            //   i值为下一个柱的坐标，依次从栈中弹出计算矩形大小。
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}