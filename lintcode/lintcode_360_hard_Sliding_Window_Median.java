// http://www.lintcode.com/en/problem/sliding-window-median/
// 九章答案 ( 多种方法 ):
// http://www.jiuzhang.com/solution/sliding-window-median/

public class Solution {
    /**
     * @param nums
     *            : A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public  ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeSet<Node> minheap = new TreeSet<Node>();
        TreeSet<Node> maxheap = new TreeSet<Node>();
        ArrayList<Integer> result = new ArrayList<Integer> ();
        
        if (k == 0)
            return result;
        
        int half = (k+1)/2;
        for(int i=0; i<k-1; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
        }
        for(int i=k-1; i<n; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
            result.add(minheap.last().val);
            remove(minheap,maxheap, new Node(i-k+1, nums[i-k+1]));
        }
        return result;
    }
    
    void add(TreeSet<Node>minheap, TreeSet<Node> maxheap, int size, Node node) {
        if (minheap.size()<size) {
            minheap.add(node);
        }
        else {
            maxheap.add(node);
        }
        if (minheap.size()==size) {
            if (maxheap.size()>0 && minheap.last().val>maxheap.first().val) {
                Node s = minheap.last();
                Node b = maxheap.first();
                minheap.remove(s);
                maxheap.remove(b);
                minheap.add(b);
                maxheap.add(s);
            }
        }
    }
    
    void remove(TreeSet<Node>minheap, TreeSet<Node> maxheap, Node node) {
        if (minheap.contains(node)) {
            minheap.remove(node);
        }
        else {
            maxheap.remove(node);
        }
    }
}

class Node implements Comparable<Node>{
    int id;
    int val;
    Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
    public int compareTo(Node other) {
        Node a =(Node)other;
        if (this.val == a.val) {
            return this.id - a.id;
        }
        return this.val - a.val;
    }
}


