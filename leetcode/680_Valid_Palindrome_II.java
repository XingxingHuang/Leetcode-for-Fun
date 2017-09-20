// 09.16
// two pointer 
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i > j) return true;
        return isvalid(s, i + 1, j) || isvalid(s, i, j - 1);
    }
    public boolean isvalid(String s, int i, int j) {
        while (i <= j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i > j;
    }
}


// build-in function of StringBuilder
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return valid(s.substring(i, j)) || valid(s.substring(i + 1, j + 1));
            } else {
                i++;
                j--;
            }

        }
        return true;
    }

    private boolean valid(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}