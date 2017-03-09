// @Author: Xingxing Huang
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 0) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
    }
    public void swap(int[] nums, int pEven, int pOdd) {
        int temp = nums[pOdd];
        nums[pOdd] = nums[pEven];
        nums[pEven] = temp;
    }
}


// // @Author: Xingxing Huang
// public class Solution {
//     /**
//      * @param nums: an array of integers
//      * @return: nothing
//      */
//     public void partitionArray(int[] nums) {
//         // write your code here;
//         int pEven = -1;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] % 2 != 0) {
//                 if (pEven != -1) {
//                     swap(nums, pEven, i);
//                     pEven++;
//                 }
//             } else if (pEven == -1) {
//                 pEven = i;
//             }
//         }
//     }
//     public void swap(int[] nums, int pEven, int pOdd) {
//         int temp = nums[pOdd];
//         nums[pOdd] = nums[pEven];
//         nums[pEven] = temp;
//     }
// }