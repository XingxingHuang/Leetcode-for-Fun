/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// 09.22  not a very good code, but esay to read;
class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0)
            return null;
        int sign = 1;
        Integer num = null;
        NestedInteger result = null;
        Stack<NestedInteger> stack = new Stack<>(); 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                if (result != null) stack.push(result);
                result = new NestedInteger();
            } else if (s.charAt(i) == ']') {
                if (num != null) result.add(new NestedInteger(num));
                num = null;
                sign = 1;
                if (!stack.isEmpty()) {
                    NestedInteger cur = stack.pop();
                    cur.add(result);
                    result = cur;
                }
            } else if (s.charAt(i) == ',') {
                if (num != null) 
                    result.add(new NestedInteger(num));
                num = null;
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else {
                if (sign == 1) {
                    if (num == null) 
                        num = Character.getNumericValue(s.charAt(i));
                    else 
                        num = num * 10 + Character.getNumericValue(s.charAt(i));
                } else {
                    if (num == null) 
                        num = - Character.getNumericValue(s.charAt(i));
                    else 
                        num = -(Math.abs(num) * 10 + Character.getNumericValue(s.charAt(i)));
                }
            } 
        }
        if (num != null) 
            return new NestedInteger(num);
        return result;
    }
}

// best solution 
public class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        // only input an integer
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger result = null;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                if (result != null) {stack.push(result);}
                result = new NestedInteger();
                l = i + 1; // set left side
            }
            if (s.charAt(i) == ']') {
                String num = s.substring(l, i);
                if (!num.isEmpty()) {
                    result.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(result);
                    result = pop;
                }
                l = i + 1; // set left side
            }
            if (s.charAt(i) == ',') {
                String num = s.substring(l, i);
                if (!num.isEmpty()) {
                    result.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = i + 1; // set the left side
            }
        }
        return result;
    }
}
 
 
// public class Solution {
//     public NestedInteger deserialize(String s) {
//         if (s == null || s.isEmpty()) {return null;}
//         if (s.charAt(0) != '[') {
//             return new NestedInteger(Integer.valueOf(s));
//         }
        
//         Stack<NestedInteger> stack = new Stack<>();
//         NestedInteger curr = null;
//         int l = 0; // l shall point to the start of a number substring; 
//                   // r shall point to the end+1 of a number substring
//         for (int r = 0; r < s.length(); r++) {
//             char ch = s.charAt(r);
//             if (ch == '[') {
//                 if (curr != null) {stack.push(curr);}
//                 curr = new NestedInteger();
//                 l = r+1;
//             } else if (ch == ']') {
//                 String num = s.substring(l, r);
//                 if (!num.isEmpty())
//                     curr.add(new NestedInteger(Integer.valueOf(num)));
//                 if (!stack.isEmpty()) {
//                     NestedInteger pop = stack.pop();
//                     pop.add(curr);
//                     curr = pop;
//                 }
//                 l = r+1;
//             } else if (ch == ',') {
//                 if (s.charAt(r-1) != ']') {
//                     String num = s.substring(l, r);
//                     curr.add(new NestedInteger(Integer.valueOf(num)));
//                 }
//                 l = r+1;
//             }
//         }
//         return curr;
//     }
// }