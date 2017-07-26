/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: O(nlogn), 可以有两种解法，two pointer 和 binary search。前提是先把array sort一下。 
 * 注意这题不简单， 有corner case, 如果有重复元素怎么办
 */
// public class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         Set<Integer> set = new HashSet<>();
//         Arrays.sort(nums2);
//         for (Integer num : nums1) {
//             if (binarySearch(nums2, num)) {
//                 set.add(num);
//             }
//         }
//         int i = 0;
//         int[] result = new int[set.size()];
//         for (Integer num : set) {
//             result[i++] = num;
//         }
//         return result;
//     }
    
//     public boolean binarySearch(int[] nums, int target) {
//         int low = 0;
//         int high = nums.length - 1;
//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//             if (nums[mid] == target) {
//                 return true;
//             }
//             if (nums[mid] > target) {
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }
//         return false;
//     }
// } 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //ArrayList<Integer> res = new ArrayList<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums1, nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for (int n: res) {
            ans[i++] = n;
        }
        return ans;
    }
    public boolean binarySearch(int[] nums, int n) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == n) {
                return true;
            }
            if (nums[mid] < n) {
                i = mid + 1; 
            } if (nums[mid] > n) {
                j = mid - 1;
            } 
        }
        return false;
    }
}