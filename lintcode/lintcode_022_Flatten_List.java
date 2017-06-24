// http://www.lintcode.com/en/problem/flatten-list/

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
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(nestedList, res);
        return res;
    }
    public void helper(List<NestedInteger> nestedList, ArrayList<Integer> res) {
        if (nestedList == null) {
            return;
        }
        for (NestedInteger list : nestedList) {
            if (list.isInteger()) {
                res.add(list.getInteger());
            } else if (list.getList().size() == 0) {
                continue;
            } else {
                helper(list.getList(), res);
            }
        }
    }
}

// 九章： http://www.jiuzhang.com/solution/flatten-list/
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        for (NestedInteger ele : nestedList)
            if (ele.isInteger())
                result.add(ele.getInteger());
            else
                result.addAll(flatten(ele.getList()));
        return result;
    }
}