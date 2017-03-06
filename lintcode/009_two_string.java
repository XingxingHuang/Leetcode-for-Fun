// @Author 黄xing
// O(n), O(1)
// ASCII http://images2015.cnblogs.com/blog/822124/201608/822124-20160819180928718-882826750.jpg
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        int[] helper = new int[128];
        for (int i = 0; i < s.length(); i++) {
            helper[s.charAt(i) - ' ']++;
        }
        for (int j = 0; j < t.length(); j++) {
            helper[t.charAt(j) - ' ']--;
        }
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] != 0) {
                return false;
            }
        }
        return true;
    }
};