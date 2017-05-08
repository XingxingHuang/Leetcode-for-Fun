/**
 * https://www.lintcode.com/en/problem/string-to-integer-ii/
 * http://www.jiuzhang.com/solutions/string-to-integer-ii/
 * 特殊情况需要考虑
 * -. 输入错误
 * -. 正负号
 * -. 大于整数范围的情况
 * -. 小数点的情况，直接忽略
 */
public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.length() < 1)
        return 0;
        
        // trim white spaces
        str = str.trim();

        char flag = '+';
 
        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;
    
        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
 
        if (flag == '-')
            result = -result;
 
        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
 
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
 
        return (int) result;
    }
}