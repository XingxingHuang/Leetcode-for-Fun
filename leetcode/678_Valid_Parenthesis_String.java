// 09.16 brute force, recursive 

class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) 
            return true;
        return check(s, 0, 0);
    }
    public boolean check(String s, int sum, int idx) {
        if (sum < 0)
            return false;
        if (idx == s.length())
            return sum == 0;
        //
        if (s.charAt(idx) == '(') {
            sum++;
            return check(s, sum, idx + 1);
        } else if (s.charAt(idx) == ')') {
            sum--;
            return check(s, sum, idx + 1);  
        } else { 
            return check(s, sum + 1, idx + 1) || check(s, sum, idx + 1) || check(s, sum - 1, idx + 1);
        }
    }
}