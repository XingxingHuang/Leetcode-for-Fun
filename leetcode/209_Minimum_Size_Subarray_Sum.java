// 10.15 two pointer 
// attention that the order to move the pointer
// [2,3,1,2,4,3]
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int min = nums.length + 1;
        while (j < nums.length) {
            sum += nums[j];
            if (sum >= s) {
                // move lower point, should move first
                while (sum >= s) {
                    sum -= nums[i];
                    i++;
                }
                min = Math.min(min, j - i + 2);
            }
            j++;
        }
        return min > nums.length ? 0 : min;
    }
}

//// Wrong code, I mis understood the problem
// class Solution {
//     public int minSubArrayLen(int s, int[] nums) {
//         int sum = 0;
//         int maxsum = 0;
//         int i = 0;
//         int j = 0;
//         int min = nums.length + 1;
//         while (j < nums.length) {
//             sum += nums[j];
//             while (sum > s) {
//                 sum -= nums[i];
//                 i++;
//             } 
//             if (sum == maxsum) {
//                 min = Math.min(min, j - i + 1);
//             } else {
//                 min = j - i + 1;
//                 maxsum = sum;
//             }
//             j++;
//         }
//         return min > nums.length ? 0 : min;
//     }
// }