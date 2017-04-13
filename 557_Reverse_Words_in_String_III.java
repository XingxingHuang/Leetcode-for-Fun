/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: 学习 char[] chars = s.toCharArray(); 和 String.valueOf(chars);
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length();) {
            int end = i;
            while (end < s.length() && chars[end] != ' ') {
                end++;
            }
            reverse(chars, i, end - 1);
            i = end + 1;
        }
        return String.valueOf(chars);
    }
    private void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }
    }
}