// 10.13   
// good practice for binary search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
            return new int[]{-1, -1};
        int[] res = new int[2];
        int i = 0; 
        int j = nums.length - 1;
        while (i < j) {
            int m = i + (j - i)/2;
            if (nums[m] < target) 
                i = m + 1;
            else
                j = m;
        }
        if (nums[i] != target) 
            return new int[]{-1, -1};
        else 
            res[0] = i;
        // search for the right;
        j = nums.length - 1;
        while (i < j) {
            int m = i + (j - i)/2 + 1;
            if (nums[m] > target)
                j = m - 1;
            else
                i = m;
        }
        res[1] = j;
        return res;
    }
}

// https://discuss.leetcode.com/topic/6327/a-very-simple-java-solution-with-only-one-binary-search-algorithm
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = Solution.firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
}