// http://www.lintcode.com/zh-cn/problem/expression-expand/
// 考察递归
// 是否是数字 Character.isDigit(c)
public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        // StringBuilder sb = new StringBuilder('');
        int num = 0;
        Stack<Object> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            // 数字
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            // 开始重复，放入数字
            } else if (c == '[') {
                stack.push(num);
                num = 0;
            // 结束重复，按照数字大小放入重复字符串。
            } else if (c == ']') {
                String newStr = popStack(stack);
                Integer count = (Integer) stack.pop();
                for (int i = 0; i < count; i++) {
                    stack.push(newStr);
                }
            // 非特殊情况，放入字符
            } else {
                stack.push(String.valueOf(c));
            }
        }
        return popStack(stack);
    }
    private String popStack(Stack<Object> stack) {
        // pop stack until get a number or empty
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }    
}




// 九章答案：
//      https://www.jiuzhang.com/solution/expression-expand
// version 1: Stack
public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        Stack<Object> stack = new Stack<>();
        int number = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '[') {
                stack.push(Integer.valueOf(number));
                number = 0;
            } else if (c == ']') {
                String newStr = popStack(stack);
                Integer count = (Integer) stack.pop();
                for (int i = 0; i < count; i++) {
                    stack.push(newStr);
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }
        
        return popStack(stack);
    }
    
    private String popStack(Stack<Object> stack) {
        // pop stack until get a number or empty
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
}

// version 2: Recursion
public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        int number = 0;
        int paren = 0;
        String subString = "";
        StringBuilder sb = new StringBuilder(); 
        
        for (char c : s.toCharArray()) {
            if (c == '[') {
                if (paren > 0) {
                    subString = subString + c;
                }
                paren++;
            } else if (c == ']') {
                paren--;
                if (paren == 0) {
                    // push number * substring to sb
                    String expandedString = expressionExpand(subString);
                    for (int i = 0; i < number; i++) {
                        sb.append(expandedString);
                    }
                    number = 0;
                    subString = "";
                } else {
                    subString = subString + c;
                }
            } else if (c >= '0' && c <= '9') {
                if (paren == 0) {
                    number = number * 10 + c - '0';
                } else {
                    subString = subString + c;
                }
            } else {
                if (paren == 0) {
                    sb.append(String.valueOf(c));
                } else {
                    subString = subString + c;
                }
            }
        }
        
        return sb.toString();
    }
}
