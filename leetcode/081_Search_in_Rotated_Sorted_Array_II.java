// 有了重复元素之后，做二分查找的时候，如果左边元素与mid相等，我们将无法之间知道元素是在左边还是在右边。因此要移动左边元素。
// 查看youtube视频，画出图就容易分析出情况： https://www.youtube.com/watch?v=ZH7dbEOx3WY
public class Solution {
    public boolean search (int[] nums, int target) {
        if (nums == null || nums.length == 0) 
            return false;
        int m = nums.length;
        int lo = 0;
        int hi = m - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return true;
            // 如果lo，mid的元素相等，无法判断mid在循环数组中的位置，因此需要移动。
            if (nums[lo] == nums[mid]) {
                while (lo <= mid && nums[lo] == nums[mid]) 
                    lo++;
            // 这里判断同leetcode 33，4
            } else if (nums[lo] < nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) 
                    hi = mid - 1;
                else 
                    lo = mid + 1;
            } else {
                if (target <= nums[hi] && target > nums[mid]) 
                    lo = mid + 1;
                else 
                    hi = mid - 1;
            }
        }
        return false;
    }
}



// 这里还是先找到环的起点，再搜索元素比较快捷，错误
// public class Solution {
//     public boolean search(int[] nums, int target) {
//         if (nums == null || nums.length == 0) {
//             return false;
//         }
//         int m = nums.length;
//         int lo = 0;
//         int hi = m - 1;
//         while (lo + 1 < hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) 
//                 return true;
//             if (nums[lo] <= nums[mid]) {
//                 lo = mid + 1;
//             } else if (nums[lo] > nums[mid]) {
//                 hi = mid;
//             } 
//         }
//         int start = 0;
//         if (nums[lo] < nums[hi]) {
//             start = lo;
//         } else {
//             start = hi;
//         }
//         // out of the range;
//         if (nums[start] > target || nums[(start - 1 + m) % m] < target)
//             return false;
//         // start search;
//         if (nums[hi] >= target) 
//             lo = start;
//         else 
//             hi = (start - 1 + m) % m;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) 
//                 return true;
//             if (nums[mid] > target) 
//                 hi = mid - 1;
//             else 
//                 lo = mid + 1;
//         }
//         return false;
//     }
// }