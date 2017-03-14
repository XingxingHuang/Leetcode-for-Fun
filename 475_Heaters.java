// @Author: 黄Xing
// 二分法在heater中查找每一个house所在区间
// 遍历所有的house 找到最大的间隔
// Time: O(NlogN)
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        // 二分查找法
        for (int house : houses) {
            int i = 0;
            int j = heaters.length - 1;
            while (i <= j) {
                int m = (i + j) / 2;
                if (heaters[m] >= house) {
                    j = m - 1;
                } else if (heaters[m] < house) {
                    i = m + 1;
                }
            }
            int dist1 = j >= 0 ? house - heaters[j] : Integer.MAX_VALUE;
            int dist2 = i <= heaters.length - 1 ? heaters[i] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}

// public class Solution {
//     public int findRadius(int[] houses, int[] heaters) {
//         Arrays.sort(houses);
//         Arrays.sort(heaters);
        
//         int i = 0, res = 0;
//         for (int house : houses) {
//             while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
//                 i++;
//             }
//             res = Math.max(res, Math.abs(heaters[i] - house));
//         }
        
//         return res;
//     }
// }


// public class Solution {
//     public int findRadius(int[] houses, int[] heaters) {
//         Arrays.sort(heaters);
//         int result = Integer.MIN_VALUE;
        
//         for (int house : houses) {
//             int index = Arrays.binarySearch(heaters, house);
//             if (index < 0) {
//                 index = ~index;
//                 int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
//                 int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                
//                 result = Math.max(result, Math.min(dist1, dist2));
//             }
//         }
        
//         return result;
//     }
// }