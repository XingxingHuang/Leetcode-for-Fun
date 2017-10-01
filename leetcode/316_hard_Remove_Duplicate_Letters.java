// 0930 注意栈的操作
class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) 
            return s;
        int[] map = new int[26];
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (char c: s.toCharArray()) 
            map[c - 'a']+=1;
        // loop
        for (char c: s.toCharArray()) {
            if (!visited[c - 'a'] && (stack.isEmpty() || stack.peek() < c)) {
                stack.push(c);
            } else if (!visited[c - 'a']){
                // pop 
                while (!stack.isEmpty() && stack.peek() > c && map[stack.peek() - 'a'] > 0) {
                    visited[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.push(c);
            }
            map[c - 'a']--;
            visited[c - 'a'] = true;
        }
        // output
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}