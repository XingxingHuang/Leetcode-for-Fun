/**
 * Fibonacci 问题
 * @athor   Xingxing Huang
 * @since   2017.04.14
 * @Time    O(n), 
 * @param   int
 * @return  int
 */
 
// public class Solution {
//     public int climbStairs(int n) {
//         if (n == 0) return 0;
//         if (n == 2) return 2;
//         if (n == 1) return 1;
//         return climbStairs(n - 2) + climbStairs(n - 1);
//     }
// }

public class Solution {
    public int climbStairs(int n) {
        //if (n <= 2) return n;
        
        int one = 1;
        int two = 0;
        int total = 0;
        for (int i = 0; i < n; i ++){
            total = one + two;
            two = one;
            one = total;
        }
        return total;
    }
}