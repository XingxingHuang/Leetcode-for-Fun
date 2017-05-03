// @Author: Xingxing Huang
// 用两个stack存放数据。每次加入数据是同时向两个栈中加入数值。在minstack中加入最小值，在stack中加入最新的数值。保证minstack中最上面的始终是当前最小值，stack和minstack中元素个数一样。
// Revised from: http://www.jiuzhang.com/solutions/min-stack/#python
public class MinStack {
    private Stack<Integer> stack, minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
