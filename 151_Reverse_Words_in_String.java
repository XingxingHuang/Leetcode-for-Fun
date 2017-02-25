// 黄xing
public class Solution {
    public String reverseWords(String s) {
        // 用栈存储字符串，空格分割
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else {
                while (s.charAt(i) == " ") {i++;}
                int j = i;
                while (i < s.length() && s.charAt(i) != ' ') {i++;}
                stack.push(" " );
                stack.push(s.substring(j, i));
            }
        }
        // 从栈中取出字符串达到reverse的目的
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            out.append(stack.pop());
        }
        return out.deleteCharAt(out.length() - 1).toString();
    }
}