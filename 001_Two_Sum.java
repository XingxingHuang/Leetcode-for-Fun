/**
 * Two Sum 题目，必须记住。
 * @author  Xingxing Huang  
 * @since   2017.04.18
 * @Time    O(n)
 * @param   int
 * @return  int[]
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
// // 该数组没有排序不能用binary search
// public class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // if (nums == null) {};
//         int end = binarySearch(nums, target);
//         for (int j = end; j > 0; j--) {
//             for (int i = 0; i < j; i++) {
//                 if (nums[i] + nums[j] == target) {
//                     int[] res = {i, j};
//                     return res;
//                 }
//                 if (nums[i] + nums[i] > target) {
//                     break;
//                 }
//             }
//         }
//         return new int[2];
//     }
    
//     public int binarySearch(int[] nums, int target) {
//         int i = 0;
//         int j = nums.length - 1;
//         while (i <= j) {
//             int m = i + (j - i) / 2;
//             if (nums[m] <= target) {
//                 i = m + 1;
//             }
//             if (nums[m] >= target) {
//                 j = m - 1;
//             }
//         }
//         return j;
//     }
// }