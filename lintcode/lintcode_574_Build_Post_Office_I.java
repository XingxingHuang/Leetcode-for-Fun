// http://www.lintcode.com/en/problem/build-post-office/
// http://www.jiuzhang.com/solutions/build-post-office/


// http://www.lintcode.com/en/problem/build-post-office-ii/#
// http://www.jiuzhang.com/solutions/build-post-office/

// 同样，最开始能够想到的也是暴力算法，即穷举每一块空地，然后用 BFS 算一下到所有房子的距离，代码实现起来也不难，就略过了。

// 但是这里还有另外一个角度来思考这个问题，即从房子的角度来看。也是用 BFS 来遍历所有的空地，不过这里就需要在每个空地中记录房子访问次数和房子距离之和了。记录访问次数是为了确保所有房子都能访问到该空地，否则就不是可行解。这种解法的优势是在于当房子数目远小于空地数目时比上面从空地出发进行 BFS 要更快一些。所以这也是一种权衡（trade-off）了，要视数据集的具体情况而定。
// http://blog.hyoung.me/cn/2017/02/build-post-office/


// 我的程序，对九章算法的方法稍微做了代码的优化。
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        ArrayList<Integer> housex = new ArrayList<>();
        ArrayList<Integer> housey = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    housex.add(i);
                    housey.add(j);
                }
            }
        }
        
        Collections.sort(housex);
        Collections.sort(housey);

        List<Integer> sumx = new ArrayList<>();
        List<Integer> sumy = new ArrayList<>();
        sumx.add(0);
        sumy.add(0);
        for (int i = 1; i <= housex.size(); i++) {
            sumx.add(sumx.get(i - 1) + housex.get(i - 1));
            sumy.add(sumy.get(i - 1) + housey.get(i - 1));
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int xdist = getDist(sumx, i, housex);
                    int ydist = getDist(sumy, j, housey);
                    // int xdist2 = get_cost(housex, sumx, i, sumx.size() - 1);
                    // int ydist2 = get_cost(housey, sumy, j, sumy.size() - 1);
                    min = Math.min(min, xdist + ydist);
                }
            }
        }
        return min;
        //  abs(x - x0) + abs(y - y0)
        //  xarr house
        //  x[0] = 0;
        //  x[1] = xarr[0] + xarr[1];
        //  x[2] = xarr[0] + . + xarr[2];
        //  x[n] = xarr[0] + .. + xarr[n];
        //  pos: house > pos 
        //  前面 ： x[n] - x[index + 1] - pos*(n - index - 1)
        //  后面 ： pos*(index + 1) - x[index + 1]
        //  sum 
    }
    private int getDist(List<Integer> sum, int pos, List<Integer> house) {
        int index = binarySearch(pos, house);
        int n = sum.size() - 1;
        return sum.get(n) - sum.get(index + 1) - pos * (n - index - 1) + 
            pos * (index + 1) - sum.get(index + 1);
    }
    private int binarySearch(int pos, List<Integer> house) {
        int i = 0;
        int j = house.size() - 1;
        if (i > pos) {
            return -1;
        }
        while (i + 1 < j) {
            int m = i + (j - i) / 2;
            if (house.get(m) > pos) {
                j = m - 1;
            } else {
                i = m;
            }
        }
        if (house.get(j) <= pos) {
            return j;
        } else {
            return i;
        }
    }
    // public int get_cost(List<Integer> x, List<Integer> sum, int pos, int n) {
    //     // 一维数组x记录坐标信息
    //     // sum 记录到原点0位置的距离累加和
    //     // pos 记录遍历的0的坐标位置
    //     // n 记录总的1的个数
    //     // 返回x中所有点到坐标为pos的距离和。计算方法是 找到pos对应的左边和右边值为1的个数。记录index。然后距离和为 
    //     // sum - sum(index + 1) - pos * (n - index - 1) 
    //     //     + (index + 1) * pos - sum(index + 1)
    //     // 注意sum的坐标从0到n。
    //     if (n == 0)
    //         return 0;
    //     if (x.get(0) > pos)
    //         return sum.get(n) - pos * n;

    //     int l = 0, r = n - 1;
    //     while (l + 1 < r) {
    //         int mid = l + (r - l) / 2;
    //         if (x.get(mid) <= pos)
    //             l = mid;
    //         else
    //             r = mid - 1;
    //     }
        
    //     int index = 0;
    //     if (x.get(r) <= pos)
    //         index = r;
    //     else
    //         index = l;
    //     return sum.get(n) - sum.get(index + 1) - pos * (n - index - 1) + 
    //           (index + 1) * pos - sum.get(index + 1);
    // }    
}


// BFS 方法，找到一堆house的中间值，然后向四周扩散，找到第一个空格位置。
class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    int m, n;
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        List<Node> houses = new ArrayList<>();
        List<Integer> xarr = new ArrayList<>();
        List<Integer> yarr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new Node(i, j));
                    xarr.add(i);
                    yarr.add(j);
                }
            }
        }
        if (houses.size() == m * n) {
            return -1;
        }
        Collections.sort(xarr);
        Collections.sort(yarr);
        int xMedian = getMedian(xarr);
        int yMedian = getMedian(yarr);
        Node cur = new Node(xMedian, yMedian);
        
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(cur);
        visited[xMedian][yMedian] = true;
        int[] dirx = new int[] {0, 0, -1, -1, -1, 1, 1, 1};
        int[] diry = new int[] {-1, 1, 0, -1, 1, 0, -1, 1};
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                int sum = Integer.MAX_VALUE;
                if (grid[cur.x][cur.y] == 0) {
                    sum = getDistance(cur, houses);
                }
                min = Math.min(min, sum);
                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dirx[j];
                    int ny = cur.y + diry[j];
                    if (inboard(nx, ny) && grid[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    private int getMedian(List<Integer> arr) {
        int Median = arr.get(arr.size() / 2);
        if (arr.size() % 2 == 0) {
            Median = (arr.get(arr.size() / 2) + arr.get(arr.size() / 2 - 1)) /2;
        }
        return Median;
    }
    private int getDistance(Node cur, List<Node> houses) {
        int total = 0;
        for (Node house: houses) {
            total = total + Math.abs(cur.x - house.x) 
                    + Math.abs(cur.y - house.y);
        }
        return total;
    }
    private boolean inboard(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}

// 方法一 
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;

        List<Integer> sumx = new ArrayList<Integer>();
        List<Integer> sumy = new ArrayList<Integer>();
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();

        // 记录坐标并排序
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
        Collections.sort(x);
        Collections.sort(y);

        int total = x.size();

        // 两个坐标累加和矩阵
        sumx.add(0);
        sumy.add(0);
        for (int i = 1; i <= total; ++i) {
            sumx.add(sumx.get(i-1) + x.get(i-1));
            sumy.add(sumy.get(i-1) + y.get(i-1));
        }

        // 对与每个空地判断距离和。
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (grid[i][j] == 0) {
                    int cost_x = get_cost(x, sumx, i, total);
                    int cost_y = get_cost(y, sumy, j, total);
                    if (cost_x + cost_y < result)
                        result = cost_x + cost_y;
                }

        return result;
    }

    public int get_cost(List<Integer> x, List<Integer> sum, int pos, int n) {
        // 一维数组x记录坐标信息
        // sum 记录到原点0位置的距离累加和
        // pos 记录遍历的0的坐标位置
        // n 记录总的1的个数
        // 返回x中所有点到坐标为pos的距离和。计算方法是 找到pos对应的左边和右边值为1的个数。记录index。然后距离和为 
        // sum - sum(index + 1) - pos * (n - index - 1) 
        //     + (index + 1) * pos - sum(index + 1)
        // 注意sum的坐标从0到n。
        if (n == 0)
            return 0;
        if (x.get(0) > pos)
            return sum.get(n) - pos * n;

        int l = 0, r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (x.get(mid) <= pos)
                l = mid;
            else
                r = mid - 1;
        }
        
        int index = 0;
        if (x.get(r) <= pos)
            index = r;
        else
            index = l;
        return sum.get(n) - sum.get(index + 1) - pos * (n - index - 1) + 
              (index + 1) * pos - sum.get(index + 1);
        // sum.get(n) - sum.get(index + 1) - pos * (n - index - 1) pos后面的房子的累加和。后面房子累加和减去pos处对应的距离
        // (index + 1) * pos - sum.get(index + 1) 前面房子的累加和，为房子数乘以pos，减去房子到0点的累加和。
    }
}

// 方法二
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        int row = grid.length, column = grid[0].length;
        if(row == 0 || column == 0 || !haveZero(grid, row, column)) {
         return -1;
        }

        // 记录房子数目累加和
        int[] rowSum = new int[row];
        int[] columnSum = new int[column]; 
        for(int i = 0; i < row; i++)
         for(int j = 0; j < column; j++)
             if(grid[i][j] == 1) {
                 rowSum[i]++;
                 columnSum[j]++;
             }

        // 分别计算x,y方向每个位置对应距离累加和
        int[] ansRow = new int[row];
        int[] ansColumn = new int[column];
        getSumDistance(rowSum, row, ansRow);
        getSumDistance(columnSum, column, ansColumn);

        // 找出累加和最小的位置。
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++)
         for(int j = 0; j < column; j++)
             if(grid[i][j] == 0 && ans > ansRow[i] + ansColumn[j]) {
                 ans = ansRow[i] + ansColumn[j];
             }
        return ans;
    }

    void getSumDistance(int[] a,int n,int[] ans) {
     int[] prefixSum1 = new int[n];
     int[] prefixSum2 = new int[n];
     /*
     第一阶段，处理前缀。
     prefixSum1记录数组 a 的前缀和，即:prefixSum1[i]=a[0]+a[1]+..+a[i].
     prefixSum2记录数组 prefixSum1 前缀和，prefixSum2即为前 i 个点到第 i 个点的代价和。
     */
     prefixSum1[0] = a[0];
     for(int i = 1; i < n; i++) {
         prefixSum1[i] = prefixSum1[i - 1] + a[i];
     }
     prefixSum2[0] = 0;
     for(int i = 1; i < n; i++) {
         prefixSum2[i] = prefixSum2[i - 1] + prefixSum1[i - 1];
         }

         for(int i = 0; i < n; i++) {
             ans[i] = prefixSum2[i];
         }

     /*
     第二阶段，处理后缀。
     prefixSum1记录数组 a 的后缀和，即:prefixSum1[i]=a[n-1]+a[n-2]+..+a[i].
     prefixSum2记录数组 prefixSum1 的后缀和，prefixSum2即为 i 之后的点到第 i 个点的代价和。
     */
     prefixSum1[n - 1] = a[n - 1];
     for(int i = n - 2; i >= 0; i--) {
         prefixSum1[i] = prefixSum1[i + 1] + a[i];
     }
     prefixSum2[n - 1] =0;
     for(int i = n - 2; i >= 0; i--) {
         prefixSum2[i] = prefixSum2[i + 1] + prefixSum1[i + 1];
         }

         for(int i = 0; i < n; i++) {
             ans[i] += prefixSum2[i];
         }

         /*
         ans[i] 即为a数组中所有点到第 i 点的代价和
         */
    }

    boolean haveZero(int[][] grid, int row, int column) {
     for(int i = 0; i < row; i++) {
         for(int j = 0; j < column; j++){
             if(grid[i][j] == 0) {
                 return true;
             }
         }
     }
     return false;
    }
}