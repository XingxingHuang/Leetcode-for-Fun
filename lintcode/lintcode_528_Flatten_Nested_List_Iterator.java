/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// import java.util.Iterator;

// public class NestedIterator implements Iterator<Integer> {

//     public NestedIterator(List<NestedInteger> nestedList) {
//         // Initialize your data structure here.
//     }

//     // @return {int} the next element in the iteration
//     @Override
//     public Integer next() {
//         // Write your code here
//     }

//     // @return {boolean} true if the iteration has more element or false
//     @Override
//     public boolean hasNext() {
//         // Write your code here
//     }

//     @Override
//     public void remove() {}
// }


// http://www.lintcode.com/en/problem/flatten-nested-list-iterator/
// 九章： http://www.jiuzhang.com/solutions/flatten-nested-list-iterator
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {

    // 存放NestedInteger, 最上面为最前面的元素，注意放入的时候需要调整顺序
    private Stack<NestedInteger> stack;
    
    private void pushListToStack(List<NestedInteger> nestedList) {
        // 导入临时栈中
        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger nested : nestedList) {
            temp.push(nested);
        }
        // 逆序放入总栈中
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushListToStack(stack.pop().getList());
        }
        
        return !stack.isEmpty();
    }
    
    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */