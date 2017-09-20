// 2017.07.29   string s1.compareTo(string s2)
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int maxlen = Math.max(s1.length, s2.length);
        for (int i = 0; i < maxlen; i++) {
            int v1 = s1.length <= i ? 0 : value(s1[i]);
            int v2 = s2.length <= i ? 0 : value(s2[i]);
            // if (v1.compareTo(v2) != 0) {
            //     return v1.compareTo(v2);
            // }
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) { 
                return -1;    
            }
        }
        return 0;
    }
    private int value(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            num = num * 10 + (c - '0');
        }
        return num;
    }
}