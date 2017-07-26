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