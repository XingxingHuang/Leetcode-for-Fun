/**
 * http://www.lintcode.com/en/problem/longest-palindromic-substring/
 * 
 */
// 马拉车算法 Manacher’s Algorithm
// http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
// 中文 
// http://cs-cjl.com/2016/06_27_leetcode_5_longest_palindromic_substring


// 暴力解法 O(n^2)
public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数情况
            int j = 1;
            while (i - j >= 0 && i + j < s.length() && 
                    chars[i - j] == chars[i + j]) {
                j++;
            }
            if (j*2 - 1 > end - begin + 1) {
                begin = i - j + 1;
                end = i + j - 1;
            }
            // 偶数情况
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < s.length() && chars[l] == chars[r]) {
                l--;
                r++;
            }
            if (r - l - 2 > end - begin) {
                begin = l + 1;
                end = r - 1;
            }
        }
        return s.substring(begin, end + 1);
    }
}

// 加‘#’解法，参见九章
// https://www.jiuzhang.com/solutions/longest-palindromic-substring/
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();    
        int max = 0;
        String result = "";
        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && 
                    // 在偶数位肯定相等返回‘#’
                    // 在奇数位比较两个元素的值
                    get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }
        
        return result;
    }
    
    private char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else 
            return s.charAt(i / 2);
    }
}
