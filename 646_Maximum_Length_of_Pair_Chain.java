// 先排序，依次从前往后计算每一个能构成的最大长度。用hashmap记录前面的长度
public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;
        if (pairs.length == 1) return 1;
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // for (int i = 0; i < pairs.length; i++) 
        //     System.out.println(""+pairs[i][0]+" "+pairs[i][1]);
        int count = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            map.put(pairs[i][1], 1);
            if (!map.isEmpty()) {
                for (int key : map.keySet()) {
                    if (key < pairs[i][0]) {
                        int tmp = Math.max(map.get(pairs[i][1]), map.get(key) + 1);
                        map.put(pairs[i][1], tmp);
                    }
                }
            }
            count = Math.max(count, map.get(pairs[i][1]));
        }
        return count;
    }
}