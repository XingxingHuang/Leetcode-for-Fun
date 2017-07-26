// stack 的应用，注意空格，实际上符号也可以看做是一个栈记录。注意边界条件
public class Solution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                num = num * 10 + (chars[i] - '0'); 
                // System.out.println(num);
            }
            // 注意条件判断
            if ((!Character.isDigit(chars[i]) && chars[i] != ' ') || i == chars.length - 1){ 
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = chars[i];
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}