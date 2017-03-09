// @Author Xingxing Huang
// 二分法
// following question: what about there are duplicated elements?  add one more line is enough
public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // // write your code here
        // if (nums == null || nums.length == 0) {
        //     return null;
        // }
        // Only one element or Increased situations
        if (nums.length == 1 || nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[low] < nums[high]) {
                return nums[0];
            }
            if (nums[low] < nums[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return Math.min(nums[low], nums[low + 1]);
    }
}

// // @Author Xingxing Huang
// // O(n)
// public class Solution {
//     /**
//      * @param nums: a rotated sorted array
//      * @return: the minimum number in the array
//      */
//     public int findMin(int[] nums) {
//         // // write your code here
//         // if (nums == null || nums.length == 0) {
//         //     return null;
//         // }
//         int min = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] < min) {
//                 min = nums[i];
//             }
//         }
//         return min;
//     }
// }