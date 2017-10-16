// 10.15
// By xingxing, best slide window solution
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        for (char c: s1.toCharArray()) 
            map1[c - 'a']++;
        int i = 0;
        while (i < s2.length()) {
            int[] map2 = new int[26];
            for (int j = i; j < s2.length(); j++) {
                int idx = s2.charAt(j) - 'a';
                // add one char
                if (map2[idx] < map1[idx]) {
                    map2[idx]++;
                } // meet new char
                else if (map1[idx] == 0) {
                    i = j + 1;
                    break;
                } // too many char, find the first apperance of that char
                else if (map2[idx] == map1[idx]) {
                    while (s2.charAt(i) != s2.charAt(j)) {
                        map2[s2.charAt(i) - 'a']--; 
                        i++;
                    }
                    i++;
                }
                // got the fit
                // System.out.println(i + " "+ j);
                if (j - i + 1 == s1.length()) 
                    return true;            
            }
            if (i + s1.length() >= s2.length()) break;
        }
        return false;
    }
}

// many solutions discussed here. 
// https://leetcode.com/problems/permutation-in-string/solution/

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }
}