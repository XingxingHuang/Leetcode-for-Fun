// 0923
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s: ops) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.push(stack.peek()*2);
            } else if (s.equals("+")) {
                int n = stack.pop();
                int m = stack.pop();
                stack.push(m);
                stack.push(n);
                stack.push(m + n);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}