// 11.19

class MyCalendar {

    public Stack<List<Integer>> stack;
    
    public MyCalendar() {
        // init the data structure here
        stack = new Stack<>();
    }
    
    public boolean book(int start, int end) {
        Stack<List<Integer>> helper = new Stack<>();
        while (!stack.isEmpty() && stack.peek().get(0) >= end) {
            // System.out.println(stack.peek().get(0));
            helper.push(stack.pop());
        }
        boolean flag = true;
        if (!stack.isEmpty() && stack.peek().get(1) > start)
            flag = false;
        else 
            // push the current value;
            stack.push(new ArrayList<Integer>(Arrays.asList(start, end)));
        // push back others
        while (!helper.isEmpty())
            stack.push(helper.pop());
        return flag;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */