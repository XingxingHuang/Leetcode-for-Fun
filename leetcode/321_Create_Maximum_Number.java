// 10.04
public class Solution { 
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k == 0) return new int[0];
        int m = nums1.length;
        int n = nums2.length;
        if (m + n < k) return null;
        if (m + n == k) return merge(nums1, nums2, k);
        
        // 从两个数组中分别选出一定数目，组成k大小的数组。循环查看最满足条件的情况。第一个数组可以取元素数目从min到max
        int max = m >= k ? k : m;
        int min = n >= k ? 0 : k - n;
        int[] results = new int[k];
        for (int i = 0; i < results.length; i++) results[i] = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) {
            int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
            results = isGreater(results, 0, temp, 0) ? results : temp;
        }
        return results;
    }
        private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] results = new int[k];
        if (k == 0) return results;
        int i = 0, j = 0;
        for(int l = 0; l < k; ++l) {
            results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return results;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        // 比较两个数的大小
        for(; i < nums1.length && j < nums2.length; ++i, ++j) {
            if (nums1[i] > nums2[j])
                return true;
            if (nums1[i] < nums2[j])
                return false;
        }
        return i != nums1.length;
    }

    private int[] getMax(int[] nums, int k) {
        if (k == 0)
            return new int[0];
        int[] results = new int[k];
        int i = 0;
        for(int j = 0; j < nums.length; ++j) {
            // 如果数组后面还有充足的元素，并且选出的元素个数不为0。新的元素比当前元素大。我们直接将数组里面所有比当前元素小的元素剔除
            while(nums.length - j + i > k && i > 0 && results[i-1] < nums[j])
                i--;
            // 还能添加元素 就继续添加。
            if (i < k)
                results[i++] = nums[j];
        }
        return results;
    }
}
// // http://www.jiuzhang.com/solutions/create-maximum-number/
// public class Solution {
//     public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//         // Write your code here
//         if (k == 0)
//             return new int[0];

//         int m = nums1.length, n = nums2.length;
//         if (m + n < k) return null;
//         if (m + n == k) {
//             int[] results = merge(nums1, nums2, k);
//             return results;
//         } else {
//             int max = m >= k ? k : m;
//             int min = n >= k ? 0 : k - n;

//             int[] results = new int[k];
//             for(int i=0; i < k; ++i)
//                 results[i] = -0x7ffffff;
//             for(int i = min; i <= max; ++i) {
//                 int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
//                 results = isGreater(results, 0, temp, 0) ? results : temp;
//             }
//             return results;
//         }
//     }

//     private int[] merge(int[] nums1, int[] nums2, int k) {
//         int[] results = new int[k];
//         if (k == 0) return results;
//         int i = 0, j = 0;
//         for(int l = 0; l < k; ++l) {
//             results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
//         }
//         return results;
//     }

//     private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
//         for(; i < nums1.length && j < nums2.length; ++i, ++j) {
//             if (nums1[i] > nums2[j])
//                 return true;
//             if (nums1[i] < nums2[j])
//                 return false;
//         }
//         return i != nums1.length;
//     }

//     private int[] getMax(int[] nums, int k) {
//         if (k == 0)
//             return new int[0];
//         int[] results = new int[k];
//         int i = 0;
//         for(int j = 0; j < nums.length; ++j) {
//             while(nums.length - j + i > k && i > 0 && results[i-1] < nums[j])
//                 i--;
//             if (i < k)
//                 results[i++] = nums[j];
//         }
//         return results;
//     }
// }