public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() ==0) return s;
        String vowels = "aeiouAEIOU";
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i <= j) {
            // while (i <= j && !vowels.contains(""+chars[j])) j --;
            // while (i <= j && !vowels.contains(""+chars[i])) i ++;
            // if (vowels.contains(""+chars[i]) && vowels.contains(""+chars[j])) {
            while (i <= j && vowels.indexOf(chars[j]) == -1) j --;
            while (i <= j && vowels.indexOf(chars[i]) == -1) i ++;
            if (vowels.indexOf(chars[i]) != -1 && vowels.indexOf(chars[j]) != -1) {
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i ++;
                j --;
            }
        }
        return new String(chars);
    }
}