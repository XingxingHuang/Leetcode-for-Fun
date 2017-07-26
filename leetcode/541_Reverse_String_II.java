/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: 注意String的操作方法，
 * s.length()   
 * char[] chars = s.toCharArray();
 * String.valueOf(chars);
 */
public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            int end = Math.min(i + k - 1, chars.length - 1);
            reverse(chars, i, end);
            i += 2 * k;
        }
        return String.valueOf(chars);
    }
    public void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }
    }
}