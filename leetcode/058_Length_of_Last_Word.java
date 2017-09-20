// 09.20 
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                len++;
                pre = len;
            } else { 
                pre = Math.max(pre, len);
                len = 0;
            }
        }
        return pre;
    }
}

// java single line
// public int lengthOfLastWord(String s) {
//     return s.trim().length()-s.trim().lastIndexOf(" ")-1;
// }