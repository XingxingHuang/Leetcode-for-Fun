// http://www.lintcode.com/en/problem/build-post-office-ii/#
// http://www.jiuzhang.com/solutions/build-post-office/

// 同样，最开始能够想到的也是暴力算法，即穷举每一块空地，然后用 BFS 算一下到所有房子的距离，代码实现起来也不难，就略过了。

// 但是这里还有另外一个角度来思考这个问题，即从房子的角度来看。也是用 BFS 来遍历所有的空地，不过这里就需要在每个空地中记录房子访问次数和房子距离之和了。记录访问次数是为了确保所有房子都能访问到该空地，否则就不是可行解。这种解法的优势是在于当房子数目远小于空地数目时比上面从空地出发进行 BFS 要更快一些。所以这也是一种权衡（trade-off）了，要视数据集的具体情况而定。
// http://blog.hyoung.me/cn/2017/02/build-post-office/

// 从空白开始BFS 搜搜
class Node {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    int m;
    int n;
    int WALL = 2;
    int[] dirx = new int[] {0, 0, 1, -1};
    int[] diry = new int[] {1, -1, 0, 0};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;

        // 找空白
        List<Node> emptys = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    emptys.add(new Node(i, j));
                }
            }
        }
        
        // 找house
        List<Node> houses = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new Node(i, j));
                }
            }
        }
        
        // bfs 搜索distance的和，找到最小值
        int min = Integer.MAX_VALUE;
        for (Node empty: emptys) {
            int distance = bfs(empty, houses, grid);
            min = Math.min(min, distance);
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    private int bfs(Node empty, List<Node> houses, int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        int step = 0;
        int sum = 0;
        int times = 0;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(empty);
        visited[empty.x][empty.y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Node newNode = new Node(cur.x + dirx[j], cur.y + diry[j]);
                    if (valid(newNode, visited)) {
                        visited[newNode.x][newNode.y] = true;
                        if (grid[newNode.x][newNode.y] == 0) { //只能穿过0
                            queue.offer(newNode);
                        }
                        if (grid[newNode.x][newNode.y] == 1) {
                            sum += step;  // 距离之和
                            times++; // house 计数
                        }
                    }
                }
            }
        }
        if (times != houses.size()) {
            return Integer.MAX_VALUE;
        }
        return sum;
    }
    private boolean valid(Node cur, boolean[][] visited) {
        int x = cur.x;
        int y = cur.y;
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
            return false;
        }
        return true;
    }
}


// 从houses 开始BFS 搜索，九章代码
class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    public int[][] grid;
    public int n, m;
    public int[] deltaX = {0, 1, -1, 0};
    public int[] deltaY = {1, 0, 0, -1};
    
    private List<Coordinate> getCoordinates(int type) {
        // 找到特定值的点
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }
    
    private void setGrid(int[][] grid) {
        // 初始化一些值
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
    }
    
    private boolean inBound(Coordinate coor) {
        // 判断边界
        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        return grid[coor.x][coor.y] == EMPTY;
    }

    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        // set n, m, grid
        setGrid(grid);
        
        // 对每一个house，记录距离累加和以及空地访问次数。
        List<Coordinate> houses = getCoordinates(HOUSE);
        int[][] distanceSum = new int[n][m];;
        int[][] visitedTimes = new int[n][m];;
        for (Coordinate house : houses) {
            bfs(house, distanceSum, visitedTimes);
        }
        
        // 对于每一个空地，如果访问次数为house大小，判断是否为最小路径和
        int shortest = Integer.MAX_VALUE;
        List<Coordinate> empties = getCoordinates(EMPTY);
        for (Coordinate empty : empties) {
            // 不成立说明某些房子到达不了目标空地
            if (visitedTimes[empty.x][empty.y] != houses.size()) {
                continue;
            }
            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }
        
        // 输出结果
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
    
    private void bfs(Coordinate start,
                     int[][] distanceSum,
                     int[][] visitedTimes) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] hash = new boolean[n][m];
        
        queue.offer(start);
        hash[start.x][start.y] = true;
        
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            // 宽搜每一个点的每一个方向
            for (int temp = 0; temp < size; temp++) {
                Coordinate coor = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Coordinate adj = new Coordinate(
                        coor.x + deltaX[i],
                        coor.y + deltaY[i]
                    );
                    if (!inBound(adj)) {
                        continue;
                    }
                    if (hash[adj.x][adj.y]) {
                        continue;
                    }
                    queue.offer(adj);
                    hash[adj.x][adj.y] = true;
                    distanceSum[adj.x][adj.y] += steps;
                    visitedTimes[adj.x][adj.y]++;
                } // direction
            } // for temp
        } // while
    }
}