public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int sign = 0;
        while(la >=0 || lb >=0) {
            // get the value 
            if (la >= 0) {
                sign += a.charAt(la) - '0';
                la--;
            }
            if (lb >= 0) {
                sign += b.charAt(lb) - '0';
                lb--;
            }
            // add to the string
            s.append(sign % 2);
            sign = sign >> 1;
        }
        if (sign != 0) {
            s.append(sign);
        }
        return s.reverse().toString();
    }
}