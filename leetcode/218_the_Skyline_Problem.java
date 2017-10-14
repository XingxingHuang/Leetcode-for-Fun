// 0922
// 对数据进行排序，采用扫描线方法对高度进行扫描。
// 对每一个高度，我们查看是否改动result。
//      每次取出最大高度，如果高度变化了，那么加入边界到result中。
//      如果高度不变，不添加。
// skline 这题属于扫描线一类。先将所有的建筑按照横坐标位置排序，然后按照坐标值大小从左往右扫描， 记录当前包含的building的最高点的位置得到最后的结果。但是每个building都有都有起始位置和结束位置，如何区分就是用了正负号来增加一个信息判断。

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] build: buildings) {
            height.add(new int[]{build[0], -build[2]});
            height.add(new int[]{build[1], build[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // smaller x first
            return a[1] - b[1]; // same x, then smaller height first, 
        });
        // 
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h: height) {
            // add or remove the new height
            if (h[1] < 0) 
                pq.offer(-h[1]);  // start of one building
            else 
                pq.remove(h[1]);  // end of one building
            // check the change
            int cur = pq.peek();  
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}

// using treemap instead to improve the time complexity
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], - b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0,1);
        int prevHeight = 0;
        List<int[]> skyLine = new LinkedList<>();
        for (int[] h: heights) {
            if (h[1] < 0) {
                Integer cnt = heightMap.get(-h[1]);
                cnt = ( cnt == null ) ? 1 : cnt + 1;
                heightMap.put(-h[1], cnt);
            } else {
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            int currHeight = heightMap.firstKey();
            if (prevHeight != currHeight) {
                skyLine.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }
}