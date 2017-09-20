// 2017.08.10 Xingxing Huang
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) 
            return digits;
        int sum = digits[digits.length - 1] + 1;
        int carry = sum / 10;
        digits[digits.length - 1] = sum % 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}

public class Solution {
    public int[] plusOne(int[] digits) {
            
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}