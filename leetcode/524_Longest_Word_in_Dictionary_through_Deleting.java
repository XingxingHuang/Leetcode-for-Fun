// 10.15 
// 10.15 slice window
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str: d) {
            if ((str.length() > res.length() || (str.length() == res.length() && res.compareTo(str) > 0)) 
                 && isSub(s, str)) {
                    res = str;
            }
        }
        return res;
    }
    private boolean isSub(String s, String sub) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < sub.length()) {
            if (sub.charAt(j) == s.charAt(i)) 
                j++;
            i++;
            if (j == sub.length()) 
                return true;
        }
        return false;
    }
}


// check the solution for many methods
// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/solution/
public class Solution {
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    public String findLongestWord(String s, List < String > d) {
        String max_str = "";
        for (String str: d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }
}