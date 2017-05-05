// http://www.lintcode.com/en/problem/single-number/
// 数学技巧
public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A[0];
        for (int i = 1; i < A.length; i++) {
            n = n ^ A[i];
        }
        return n;
    }
}