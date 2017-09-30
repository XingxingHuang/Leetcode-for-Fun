// 0929
class Solution {
    public String convertToBase7(int num) {
        int sign = num >= 0 ? 1 : -1;
        num = Math.abs(num);
        int level = 1;
        int m = 0;
        while (num > 0) {
            m += level * (num % 7);
            level *= 10;
            num = num/7;
        }
        return sign == 1 ? ""+m : "-"+m;
    }
}


// recursive
public String convertTo7(int num) {
    if (num < 0)
        return '-' + convertTo7(-num);
    if (num < 7)
        return num + "";
    return convertTo7(num / 7) + num % 7;
}