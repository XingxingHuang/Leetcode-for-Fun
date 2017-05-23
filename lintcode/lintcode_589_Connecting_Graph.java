// http://www.lintcode.com/en/problem/connecting-graph/
// union find 典型题目
public class ConnectingGraph { 
    private int[] father;
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
        }
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        int fa = find(a);
        int fb = find(b);
        return fa == fb;
    }
}