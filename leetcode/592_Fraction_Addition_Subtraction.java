// Author: XingxingHuang 2017.07.27, brute force
public class Solution {
    public String fractionAddition(String expression) {
        int sign = 1;
        long a = 0;
        long b = 1;
        int i = 0;
        while (i < expression.length()) {
            // sign
            if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (expression.charAt(i) == '+') {
                sign = 1;
                i++;
            } else {
                sign = 1;
            }
            // a
            long tempa = 0;
            while (expression.charAt(i) - '0' >= 0 && expression.charAt(i) - '9' <= 0) {
                tempa = tempa * 10 + (expression.charAt(i) - '0');
                i++;
            }
            // b
            i++;
            long tempb = 0;
            while (i < expression.length() && expression.charAt(i) - '0' >= 0 && expression.charAt(i) - '9' <= 0) {
                tempb = tempb * 10 + (expression.charAt(i) - '0');
                i++;
            }
            // add together
            a = a * tempb + sign * tempa * b;
            b = b * tempb;
            // irreducible
            if ( a == 0) 
                b = 1;
            long limit = Math.min(Math.abs(a), b);
            for (int j = 2; j <= limit; j++) {
                if (a % j == 0 && b % j == 0) {
                    a /= j;
                    b /= j;
                    j--;
                }
            }
        }
        String res = "";
        if (a < 0) res += "-";
        return res + Math.abs(a) + "/" + b;
    }
}

// https://leetcode.com/problems/fraction-addition-and-subtraction/tabs/solution
// how to calculate the gcd
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }