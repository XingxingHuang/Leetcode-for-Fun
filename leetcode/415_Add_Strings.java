// 2017.08.23 XingxingHuang
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int carry = 0;
        int i = 0;
        while (i < m && i < n) {
            int num = (num1.charAt(m - i - 1) - '0') + (num2.charAt(n - i - 1) - '0') + carry;
            carry = num / 10;
            num = num % 10;
            sb.append(String.valueOf(num));
            i++;
        }
        while (i < m) {
            int num = (num1.charAt(m - i - 1) - '0') + carry;
            carry = num / 10;
            num = num % 10;
            sb.append(String.valueOf(num));
            i++;
        }
        while (i < n) {
            int num = (num2.charAt(n - i - 1) - '0') + carry;
            carry = num / 10;
            num = num % 10;
            sb.append(String.valueOf(num));
            i++;
        }
        if (carry != 0) {
            sb.append(String.valueOf(carry));
        }
        return (sb.length() == 0) ? "0" : sb.reverse().toString();
    }
}


public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}