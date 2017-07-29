/**
 * https://leetcode.com/problems/sort-colors/#/description
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 */
// public class Solution { 
//     public void sortColors(int[] nums) {
//         // 1-pass
//         int p1 = 0, p2 = nums.length - 1, index = 0;
//         while (index <= p2) {
//             if (nums[index] == 0) {
//                 nums[index] = nums[p1];
//                 nums[p1] = 0;
//                 p1++;
//             }
//             if (nums[index] == 2) {
//                 nums[index] = nums[p2];
//                 nums[p2] = 2;
//                 p2--;
//                 index--;
//             }
//             index++;
//         }
//     }
// }

public class Solution { 
    public void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
                index++;
            }else if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
            } else {
                index++;
            }
        }
    }
}

// public void sortColors(int[] nums) {
//     // 2-pass
//     int count0 = 0, count1 = 0, count2 = 0;
//     for (int i = 0; i < nums.length; i++) {
//         if (nums[i] == 0) {count0++;}
//         if (nums[i] == 1) {count1++;}
//         if (nums[i] == 2) {count2++;}
//     }
//     for(int i = 0; i < nums.length; i++) {
//         if (i < count0) {nums[i] = 0;}
//         else if (i < count0 + count1) {nums[i] = 1;}
//         else {nums[i] = 2;}
//     }
// }

// 无法通过测试用例，因为如果i,j都指向1时，将超时。
// public class Solution {
//     public void sortColors(int[] nums) {
//         if (nums == null || nums.length < 1) {
//             return;
//         }
//         int n = nums.length;
//         int i = 0;
//         int j = n - 1;
//         while (i <= j) {
//             while (i <= j && nums[i] == 0) {
//                 i++;
//             }
//             while (i <= j && nums[j] == 2) {
//                 j--;
//             }
//             if (i <= j && nums[i] == 2) {
//                 swap(nums, i, j--);
//             }
//             if (i <= j && nums[j] == 0) {
//                 swap(nums, i++, j);
//             }            
//         }
//     }
//     public void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }