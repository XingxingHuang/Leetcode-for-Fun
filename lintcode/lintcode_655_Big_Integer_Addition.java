// http://www.lintcode.com/en/problem/big-integer-addition/
// 注意长度不等的情况，注意判断carry最后可能进位。
public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            carry = sum / 10;
            sum = sum % 10;
            sb.insert(0, sum);
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}

// 九章答案
// http://www.jiuzhang.com/solutions/big-integer-addition/
public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        String result = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            result = carry % 10 + result;
            carry /= 10;
        }
        return carry > 0 ? "1" + result : result;
    }
}