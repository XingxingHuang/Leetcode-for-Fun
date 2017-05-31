/** http://www.lintcode.com/en/problem/number-of-islands-ii/
 * 通过unionfind 每次更新island
 * 
 * 修改自九章
 * http://www.jiuzhang.com/solutions/number-of-islands-ii/
 * 将class 放入外面，在class中增加count参数。
 */
 
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if (operators == null) {
            return ans;
        }
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int[][] island = new int[n][m];
        
        UnionFind uf = new UnionFind(n, m);
        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x;
            int y = operators[i].y;
            // add new island
            if (island[x][y] != 1) {
                island[x][y] = 1;
                uf.set_count(); // count++
                int id = coverttoID(x, y, m);
                // convert four directory
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && 
                                island[nx][ny] == 1) {
                        int nid = coverttoID(nx, ny, m);
                        uf.union(id, nid);
                    }
                }
            }
            ans.add(uf.count);
        }
        return ans;
    }
    int coverttoID(int x, int y, int m) {
        return x * m + y;
    }
}

class UnionFind {
    HashMap<Integer, Integer> father = new HashMap<>();
    int count = 0;

    UnionFind (int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int id  = coverttoID(i, j, m);
                father.put(id, id);
            }
        }
    }
    
    int coverttoID(int x, int y, int m) {
        return x * m + y;
    }    
    
    int compressed_find(int x) {
        int parent = father.get(x);
        while(parent != father.get(parent)) {
            parent = father.get(parent);
        }
        int temp = -1;
        int fa = x;
        while (fa != father.get(fa)) {
            temp = father.get(fa);
            father.put(fa, parent);
            fa = temp;
        }
        return parent;
    }
    
    void set_count() {
        count++;
    }
    
    void union(int x, int y) {
        int fa_x = compressed_find(x);
        int fa_y = compressed_find(y);
        if(fa_x != fa_y) {
            father.put(fa_x, fa_y);
            count--;
        }
    }
}