// String manipulation
// 10.10
class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                a++;
                if (a > 1) return false;
            }
            if (s.charAt(i) == 'L') {
                if ( l == 0 || (i > 0 && s.charAt(i - 1) == 'L')) l++;
                if (l > 2) return false;
            } else {
                l = 0;
            }
        }
        return true;
    }
}


// one line
public boolean checkRecord(String s) {
    return !s.matches(".*LLL.*|.*A.*A.*");
}


// 3 line without reg
public class Solution {
    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
}