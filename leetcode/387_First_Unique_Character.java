public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.equals("")) return -1;
        char[] c = s.toCharArray();
        int[] cnt = new int[256];
                
        for (int i = 0; i < c.length; i++) {
            cnt[c[i]]++;
        }

        for (int i = 0; i < c.length; i++) {
            if (cnt[c[i]] == 1) return i; 
        }
        return -1;
    }
}