/**
 * 用binary search 达到最好的时间复杂度，但是注意如何判断。还是以用递归的二分法
 * @athor  Xingxing Huang
 * @since  2017.04.13
 * @Time   O(n) O(nlogn)
 * @param  int[]
 * @return int
 */
public class Solution {
   public int findPeakElement(int[] nums) {
       if (nums == null || nums.length <=1) {
           return 0;
       }
       int low = 0;
       int high = nums.length - 1;
       while (low < high) {
           int mid = low + (high - low) / 2;
           int mid2 = mid + 1;
           if (nums[mid] < nums[mid2]) {
               low = mid2;
           } else {
               high = mid;
           }
       } 
       return low;
   } 
}
 
// // 这里是O(n)的方法 
// public class Solution {
//     public int findPeakElement(int[] nums) {
//         if (nums == null || nums.length <= 1) {
//             return 0;
//         }
//         if (nums[0] > nums[1]) {
//             return 0;
//         }
//         for (int i = 2; i < nums.length; i++) {
//             if (nums[i - 1] > nums[i]) {
//                 return i - 1;
//             }
//         }
//         return nums.length - 1;
//     }
// }

// //下面是第一次刷题的代码， 很不好；
// public class Solution {
//     public int findPeakElement(int[] nums) {
//         if (nums == null || nums.length <= 1) {return 0;}
//         if (nums[0] > nums[1]) {return 0;}
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > nums[i - 1]) {
//                 if (i == nums.length - 1) {
//                     return i;
//                 } 
//                 if (i <= nums.length - 2) {
//                     if (nums[i] > nums[i + 1]) {return i;}
//                 }
//             }
            
//         }
//         return 0;
//     }
// }