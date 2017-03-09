// @Author Xingxing Huang
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
       // do initialization if necessary
       // push only
       stack1 = new Stack<Integer>();
       // pop only
       stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        // write your code here
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
}