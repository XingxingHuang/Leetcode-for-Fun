// 2017.07.31 XingxingHuang
// 采用第二个函数简化对palindrommic string的判断。
public class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += explore(s, i, i);
            count += explore(s, i, i + 1);
        }
        return count;
    }
    private int explore(String s, int m, int n) {
        if (n >= s.length() || m < 0) 
            return 0;
        if (s.charAt(m) == s.charAt(n)) {
            return 1 + explore(s, m - 1, n + 1);
        }
        return 0;
    }
}


// 10.06
// 从每个字符位置向外展开对Palindrome进行计数，需要考虑奇数和偶数的情况即可。
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += helper(s, i, i);
            count += helper(s, i, i + 1);
        }
        return count;
    }
    private int helper(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}