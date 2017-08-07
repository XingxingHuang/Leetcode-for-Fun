// 2017.08.02 XingxingHuang
// corner case!! be careful for the length.
// Check the best solution! OMG
public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() > b.length()) {
            return a.length();
        } else if (a.length() < b.length()) {
            return b.length();
        }
        int count = -1;
        for (int len = a.length(); len >= 0; len--) {
            if (len <= count) 
                break;
            for (int i = 0; i + len <= a.length(); i++) {
                if (!check(a.substring(i, i + len), b)) {
                    count = len;
                }
            }
        }
        return count;
    }
    private boolean check(String substr, String str) {
        // 检查substr是否是str的子串
        for (int i = 0; i + substr.length() <= str.length(); i++) {
            boolean flag = true;
            int j = 0;
            while (j < substr.length() && substr.charAt(j) == str.charAt(j + i)) 
                j++;
            if (j == substr.length()) 
                return true;
        }
        return false;
    }
}

// best solution !!
public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
}