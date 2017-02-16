
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<String>();
        backtrack(s, "", 0, 0, n);
        return s;
    }
    
    public void backtrack(List<String> s, String str, int left, int right, int n) {
        // 如果字符串已经使用n个括号
        if (str.length() == 2 * n) {
            s.add(str);
            return;
        }
        // 如果可以添加左括号
        if (left < n) { 
            backtrack(s, str + '(', left + 1, right, n);
        }
        // 如果可以添加右括号
        if (right < left) {
            backtrack(s, str + ')', left, right + 1, n);
        }
    }
}