// http://www.lintcode.com/en/problem/trapping-rain-water-ii/
//九章答案：
// http://www.jiuzhang.com/solution/trapping-rain-water-ii/
class Cell{
    public int x,y, h;
    Cell(){}
    Cell(int xx,int yy, int hh) {
        x= xx;
        y= yy;
        h =hh;
    }
}
class CellComparator implements Comparator<Cell> {
    @Override
    public int compare(Cell x, Cell y) {
        return x.h - y.h;
    }
} 


public class Solution {
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    public  int trapRainWater(int[][] heights) {
       // write your code here
        if(heights.length == 0) {
            return 0;
        }
        PriorityQueue<Cell> q =  new PriorityQueue<Cell>(1,new CellComparator());
        int n = heights.length;
        int m = heights[0].length;
        int[][] visit = new int[n][m];
      
        // 添加最外环的元素
        for(int i = 0; i < n; i++) {
            q.offer(new Cell(i,0,heights[i][0]));
            q.offer(new Cell(i,m-1,heights[i][m-1]));
            visit[i][0] = 1;
            visit[i][m-1] = 1;
        }
        for(int i = 0; i < m; i++) {
            q.offer(new Cell(0,i,heights[0][i]));
            q.offer(new Cell(n-1,i,heights[n-1][i]));
            visit[0][i] = 1;
            visit[n-1][i] = 1;
        }
        int ans = 0 ;
        // 一次取出边界上最小的区域，向内收缩
        while(!q.isEmpty()) {
            Cell now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && visit[nx][ny] == 0) {
                    visit[nx][ny] = 1;
                    // 放入蓄水的边界高度，计算增加的需水量，
                    q.offer(new Cell(nx,ny,Math.max(now.h,heights[nx][ny])));
                    ans = ans + Math.max(0, now.h - heights[nx][ny]);
                }
            }
        }
        return ans;
    }
}