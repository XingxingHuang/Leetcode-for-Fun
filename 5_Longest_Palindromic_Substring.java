/**
 * DP问题。
 * 尝试过用一维数组，但是没办法考虑奇数和偶数的回文情况
 * 解决方法是用二维DP数组，或者对数组中加上"#"然后中心展开
 * @author  Xingxing Huang  
 * @since   2017.04.27
 * @Time    O(n),   
 * @param   
 * @return  
 */
// 中心展开法  http://www.cnblogs.com/yuzhangcmu/p/4189068.html
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        
        String ret = null;
        
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            String s1 = getLongest(s, i, i);
            String s2 = getLongest(s, i, i + 1);
            
            if (s1.length() > max) {
                max = Math.max(max, s1.length());
                ret = s1;
            }
            
            if (s2.length() > max) {
                max = Math.max(max, s2.length());
                ret = s2;
            }
        }
        
        return ret;
    }
    
    public String getLongest(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            // when i is in the center.
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }
}


// 动态规划方法
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int max = 0;
        String res = null;
        
        int m = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[m][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = (chars[i] == chars[j]) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
} 

 
// 对每一个字符向两边扩张查看是否是回文串，但是字符串过长的时候会TLE
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
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
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