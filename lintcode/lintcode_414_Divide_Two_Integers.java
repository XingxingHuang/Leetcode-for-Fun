// http://www.lintcode.com/en/problem/divide-two-integers/
// 注意corner case： 0， 1， 相等，还有负数最大值的绝对值会溢出的情况

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        // corner case
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }        
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;  // overflow
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;  // 下面计算会overflow
            }
        }
        // use sign 
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long a = Math.abs((long)dividend); //采用long来计算
        long b = Math.abs((long)divisor);
        // using bit calculation 
        int res = 0;
        while (a >= b) { // 注意等号
            int level = 0;
            long tmp = a;
            while (tmp >= b) { // 注意等号
                level++;
                tmp = tmp >> 1;
            }
            a -= (b << (level - 1));
            res += (1 << (level - 1));
        }
        return sign * res;
    }
}

// http://www.jiuzhang.com/solution/divide-two-integers/