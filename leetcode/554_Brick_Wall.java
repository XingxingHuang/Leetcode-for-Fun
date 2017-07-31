// 2017.07.31 XingxingHuang
// 用hashmap记录每个位置的空隙的个数，墙壁厚度减去最大空隙个数既得。
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (List<Integer> list : wall) {
            int len = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                len += list.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
                count = Math.max(count, map.get(len));
            }
        }
        return wall.size() - count;
    }
}