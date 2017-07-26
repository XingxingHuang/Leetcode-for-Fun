// @Author 黄xing
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] next = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        // 维护一个栈结构存储已经遍历过的index，
        for (int i = 0; i < nums.length * 2 ; i++) {
            // 当前元素比栈顶对应元素大的时候找到目标，pop
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                next[stack.pop()] = nums[i % nums.length];
            }
            // 当前元素进栈, push, 栈结构中的数组元素始终是递减的。
            if (i < nums.length) {
                stack.push(i);
            }
        }
        // 栈中还剩最大值
        while (!stack.isEmpty()) {
            next[stack.pop()] = -1;
        }
        return next;
    }
}