// // stack 的应用，注意空格，实际上符号也可以看做是一个栈记录。注意边界条件
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


// 2017.09.10
// 错误代码，没有考虑加减符号的顺序，不能通过例子 例如“1-1+1”
// class Solution {
//     public int calculate(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         Stack<Character> stackOpr = new Stack<>();
//         Stack<Integer> stackNum = new Stack<>();
//         int i = 0;
//         while (i < s.length()) {
//             // get number 
//             int n = 0;
//             while (i < s.length() && s.charAt(i) != '*' 
//                    && s.charAt(i) != '+'
//                    && s.charAt(i) != '-'
//                    && s.charAt(i) != '/') {
//                 if (s.charAt(i) == ' ') {
//                     i++;
//                     continue;
//                 }
//                 n = n * 10 + (s.charAt(i) - '0');
//                 i++;
//             }
//             System.out.println(n);
//             // get operation
//             if (i == s.length()) {
//                 stackNum.push(n);
//             } else if (!stackOpr.isEmpty() && stackOpr.peek() == '/') {
//                 stackNum.push(stackNum.pop() / n);
//             } else if (!stackOpr.isEmpty() && stackOpr.peek() == '*') {
//                 stackNum.push(stackNum.pop() * n);
//             } else {
//                 stackNum.push(n);
//                 stackOpr.push(s.charAt(i));
//             }
//             i++;
//         }
//         // could have / or * left 
//         int n = stackNum.pop();
//         if (!stackOpr.isEmpty() && stackOpr.peek() == '/') {
//             n = stackNum.pop() / n;
//             stackOpr.pop();
//         } else if (!stackOpr.isEmpty() && stackOpr.peek() == '*') {
//             n = stackNum.pop() * n;
//             stackOpr.pop();
//         }
//         // calculate 
//         while (!stackNum.isEmpty()) {
//             if (stackOpr.pop() == '+') {
//                 n = n + stackNum.pop();
//             } else {
//                 n = stackNum.pop() - n;
//             }
//         }
//         return n;
//     }
// }