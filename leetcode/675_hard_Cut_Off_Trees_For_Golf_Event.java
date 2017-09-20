//  all the trees in this forest in the order of tree's height
//  No trees have the same heights.
/** hit:
 *    one array to record the trees in order
 *    DPS search for each tree.
 **/

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        if(n == 0) return 0;
        int m = forest.get(0).size();
        if(m == 0) return 0;
        
        int[][] map = new int[n][m];     // a copy of forest
        int[][] hs = new int[n*m+1][];   // for trees

        int p = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                map[i][j] = forest.get(i).get(j);
                if(map[i][j] > 1){
                    hs[p++] = new int[]{map[i][j], i, j};
                }
            }
        }
        
        hs[p++] = new int[]{0, 0, 0}; // put the original position
        hs = Arrays.copyOf(hs, p);
        Arrays.sort(hs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int ret = 0;
        for(int i = 0;i < p - 1; i++){
            // find distance for every tree with height
            int value = distMap(map, hs[i][1], hs[i][2], hs[i+1][1], hs[i+1][2]); 
            if(value == 0) return -1;
            ret += value - 1;
        }
        return ret;
    }

    public int distMap(int[][] map, int sr, int sc, int er, int ec) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = map.length;
        int m = map[0].length;
        int l = dir.length;
        
        int[][] d = new int[n][m];
        int B = 6;
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(sr << B | sc);  // Use a big Integer to store the position (x, y for first and end 6 digit)
        d[sr][sc] = 1; // 0 for no visited, >0 for steps. 

        while(!q.isEmpty()){
            int cur = q.poll();
            int r = cur >> B, c = cur & ((1 << B) - 1);
            for(int k = 0; k < l; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 0 && d[nr][nc] == 0) { 
                    d[nr][nc] = d[r][c] + 1;
                    q.add(nr<<B | nc);
                    if (nr == er && nc == ec) 
                        return d[er][ec];
                }
            }
        }
        return d[er][ec];
    }

}   



//
class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        if(n == 0) return 0;
        int m = forest.get(0).size();
        if(m == 0) return 0;
        
        int[][] map = new int[n][m];
        int[][] hs = new int[n*m+1][];
        int p = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                map[i][j] = forest.get(i).get(j);
                if(map[i][j] > 1){
                    hs[p++] = new int[]{map[i][j], i, j};
                }
            }
        }
        
        hs[p++] = new int[]{0, 0, 0};
        hs = Arrays.copyOf(hs, p);
        Arrays.sort(hs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int ret = 0;
        for(int i = 0;i < p-1;i++){
            int[][] d = distMap(map, hs[i][1], hs[i][2]);
            int v = d[hs[i+1][1]][hs[i+1][2]];
            if(v > 10000) return -1;
            ret += v;
        }
        return ret;
    }

    public int[][] distMap(int[][] map, int sr, int sc)
    {
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int n = map.length;
        if(n == 0) return new int[0][0];
        int m = map[0].length;
        int l = dr.length;
        int[][] d = new int[n][m];
        int I = 999999999;
        for(int i = 0;i < n;i++) {
            Arrays.fill(d[i], 999999999);
        }

        int B = 6;
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(sr<<B|sc);
        d[sr][sc] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            int r = cur>>>B, c = cur&(1<<B)-1;
            for(int k = 0;k < l;k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 0 && d[nr][nc] == I) { // fix
                    d[nr][nc] = d[r][c] + 1;
                    q.add(nr<<B|nc);
                }
            }
        }
        return d;
    }

}   
