// 9.15
// Consider all possibilities:
// discards all leading whitespaces
// sign of the number
// overflow
// invalid input
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
            
        int i = 0;
        int INT_MAX = Integer.MAX_VALUE;
        
        int sign = 1;
        while (str.charAt(i) == ' ') i++;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') 
            sign = str.charAt(i++) == '-' ? -1 : 1;
        
        int res = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (res >  INT_MAX / 10 || (res == INT_MAX / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == 1) 
                    return INT_MAX;
                else 
                    return Integer.MIN_VALUE;
            }
            res = 10 * res + (str.charAt(i++) - '0');
        }
        return res * sign;
    }
}