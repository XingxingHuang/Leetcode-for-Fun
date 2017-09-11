// 2017.09.10
// 尝试过使用递归的方法，先检查有无括号，有括号，那么就找到对应的反括号，然后计算，但是涉及的变量很多。
// 尝试过用while循环+递归，但是编写起来代码复杂度比较高, 主要是i的变化比较麻烦。 如下
// class Solution {
//     public int calculate(String s) {
//         Stack<Integer> stack = new Stack<>();
//         int i = 0;
//         int sign = 1;
//         int res = 0;
//         while (i < s.length()) {
//             if (s.charAt(i) == '-') {
//                 sign = -1;
//                 i++;
//             } else if (s.charAt(i) == '+') {
//                 sign = 1;
//                 i++;
//             } else if (s.charAt(i) == '(') {
//                 int num = 1;
//                 int j = i + 1;
//                 while (num != 0) {
//                     if (s.charAt(j) == '(') num++;
//                     else if (s.charAt(j) == ')') num--;
//                     j++;
//                 }
//                 // System.out.println(s.substring(i + 1, j - 1));
//                 res += sign * calculate(s.substring(i + 1, j - 1));
//                 i = j;
//             } else {
//                 int n = 0;
//                 while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')) {
//                     if (s.charAt(i) != ' ') {
//                         n = n * 10 + (s.charAt(i) - '0');
//                     }
//                     i++;
//                 }
//                 res += sign * n;
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * number;  
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
}