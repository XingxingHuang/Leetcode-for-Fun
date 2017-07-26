/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: O(n), 请查看solution 的详细分析：
 * https://discuss.leetcode.com/topic/43296/java-simple-and-clean-with-explanations-6-solutions
 */
public class Solution {
    public String reverseString(String s) {
        char[] chs = s.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i < j) {
            char ch = chs[i];
            chs[i] = chs[j];
            chs[j] = ch;
            i++;
            j--;
        }
        return String.valueOf(chs);
    }
}