// 2017.07.26   
// @Author: Xingxing Huang
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) 
            return nums;
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) 
            return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }
}

// Three solutions: // https://leetcode.com/problems/reshape-the-matrix/tabs/solution
// Using queue: take all elements out and then put them into new array.
// Without using extra Space, two loops for the origin array
// Using division and modulus, like what I have done