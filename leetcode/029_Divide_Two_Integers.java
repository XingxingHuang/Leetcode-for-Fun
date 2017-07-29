// corner case: 除数为0，负数，被除数或者除数为-2147483648。
// 注意: 负数或者任意数去绝对值时，注意Integer.MIN_VALUE的情况。
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) 
            return Integer.MAX_VALUE;
        long res = 0;
        long sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) 
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        while (ldividend >= ldivisor) {
            long count = 0;
            long tmp = ldivisor;
            while (ldividend >= tmp) {
                tmp = tmp << 1;
                count = count == 0 ? 1 : count << 1;
            }
            ldividend -= (tmp >> 1);
            res += count;
        } 
        if (res > Integer.MAX_VALUE) {
            if (sign == 1) 
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        return (int) (res * sign);
    }
}