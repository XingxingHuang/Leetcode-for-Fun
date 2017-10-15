class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) 
            return 0;
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                int l = i;
                int r = i + 1;
                while (l >= 0 && r < s.length() && s.charAt(i) == s.charAt(l) && s.charAt(i + 1) == s.charAt(r)) {
                    count++;
                    l--;
                    r++;
                }
            }
        }
        return count;
    }
}