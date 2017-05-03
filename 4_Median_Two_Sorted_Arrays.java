/**
 * 分治问题，并且需要考虑数组大小的一些边界情况，以及奇数和偶数的情况。
 * 思路比较容易想到，要找两个排序数组中的中值，那么我们可以查看两个数组的中间值，mid1, mid2
 * mid1 < mid2:
 *  也就是第一个数组后部分还有比第二个数组前半部分小的元素。
 *  因此中值出现在第一个数组后部分，或第二数组前部分。
 * @author  Xingxing Huang  
 * @since   2017.05.03
 * @Time    O(n)    
 * @param   int[], int[]
 * @return  double
 */
 
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if ((len & 1) == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2) 
                    + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.;
        }
    }
    
    public double findKth(int[] nums1, int lo1, int[] nums2, int lo2, int k) {
        // if one array gets the end;
        if (lo1 >= nums1.length) {
            return nums2[lo2 + k - 1];
        }
        if (lo2 >= nums2.length) {
            return nums1[lo1 + k - 1];
        }
        // terminal condition
        if (k == 1) {
            return Math.min(nums1[lo1], nums2[lo2]);
        }
        // divide the selection regions
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (lo1 + k/2 -1 < nums1.length) {
            mid1 = nums1[lo1 + k/2 -1];
        }
        if (lo2 + k/2 -1 < nums2.length) {
            mid2 = nums2[lo2 + k/2 - 1];
        }
        if (mid1 < mid2) {
            return findKth(nums1, lo1 + k/2, nums2, lo2, k - k/2);
        } 
        return findKth(nums1, lo1, nums2, lo2 + k/2, k - k/2);
    }
}