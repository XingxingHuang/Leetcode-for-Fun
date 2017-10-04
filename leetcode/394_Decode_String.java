// 1003
public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}

// python
def decodeString(self, s):
    while '[' in s:
        s = re.sub(r'(\d+)\[([a-z]*)\]', lambda m: int(m.group(1)) * m.group(2), s)
    return s


// // 错误代码  
// // case "3[a2[c]]"
// // output "acccccc" Expected "accaccacc"
// class Solution {
//     public String decodeString(String s) {
//         Stack<Integer> stackint = new Stack<>();
//         Stack<StringBuilder> stackstr = new Stack<>();
//         int idx = 0;
//         while (idx < s.length()) {
//             if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
//                 int count = 0;
//                 while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
//                     count = count*10 + s.charAt(idx) - '0';
//                     idx++;
//                 }
//                 stackint.push(count);
//             } else if (s.charAt(idx) == '[') {
//                 stackstr.push(new StringBuilder());
//                 idx++;
//             } else if (s.charAt(idx) == ']') {
//                 StringBuilder sb = stackstr.pop();
//                 StringBuilder sbnew = new StringBuilder();
//                 int count = stackint.pop();
//                 for (int i = 0; i < count; i++) {
//                     sbnew.append(sb);
//                 }
//                 stackstr.push(sbnew);
//                 idx++;
//             } else {
//                 StringBuilder sb = stackstr.isEmpty() ? new StringBuilder() : stackstr.pop();
//                 while (idx < s.length() && s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') { 
//                     sb.append(s.charAt(idx));
//                     idx++;
//                 }
//                 stackstr.push(sb);
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         while (!stackstr.isEmpty()) 
//             sb.insert(0, stackstr.pop());
//         return sb.toString();
//     }
// }