// @author 黄xing
public class Solution {
    public String shortestPalindrome(String s) {
        if (isPalindrome(s)) {return s;}
        // 找出字符串前面有最长的回文字符串
        int start = 0;
        for (int i = s.length(); i >
        1 ; i--) {
            if (isPalindrome(s.substring(0, i))) {
                start = i;
                break;
            }
        }
        // 直接将最长回文字符串后方字符串翻转放在前方即可
        if (start == 0 ) {
            return new StringBuffer(s.substring(1, s.length())).reverse() + s;
        } else {
            return new StringBuffer(s.substring(start, s.length())).reverse() + s;
        } 
    }
    
    // 判断是否为回文字符串
    public Boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    } 
    
    // // time out if using this method 
    // public Boolean isPalindrome(String s) {
    //     StringBuffer sb = new StringBuffer(s);
    //     return (s.equals(sb.reverse().toString()));
    // } 
}






// public class Solution {
//     public String shortestPalindrome(String s) {
//         if (isPalindrome(s)) {return s;}
//         int start = 0;
//         int end = 0;
//         for (int i = 2; i < s.length(); i++) {
//             if (isPalindrome(s.substring(0, i))) {start = i;}
//             if (isPalindrome(s.substring(s.length() - i, s.length()))) {end = i;}
//         }
//         if (start == 0 && end == 0) {
//             return new StringBuffer(s.substring(1, s.length())).reverse() + s;
//         }
//         if (start >= end) {
//             return new StringBuffer(s.substring(start, s.length())).reverse() + s;
//         } else {
//             return s + new StringBuffer(s.substring(0, s.length() - end)).reverse();
//         }
//     }
    
//     public Boolean isPalindrome(String s) {
//         if (s.length() <= 1) {
//             return true;
//         }
//         for (int i = 0; i < s.length() / 2; i++) {
//             if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
//                 return false;
//             }
//         }
//         return true;
//     } 
// }

