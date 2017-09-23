// hashmap
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++)  map[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)  {
            map[t.charAt(i) - 'a']--;
            if (map[t.charAt(i) - 'a'] < 0) return t.charAt(i);
        }
        return ' ';
    }
}

// bit manipulation
public char findTheDifference(String s, String t) {
    char c = 0;
    for (int i = 0; i < s.length(); ++i) {
        c ^= s.charAt(i);
    }
    for (int i = 0; i < t.length(); ++i) {
        c ^= t.charAt(i);
    }
    return c;
}