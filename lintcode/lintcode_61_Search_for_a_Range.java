// https://www.lintcode.com/en/problem/search-for-a-range/
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[] {-1, -1};
        if (A == null || A.length == 0) {
            return res;
        }
        int i = 0;
        int j = A.length - 1;
        boolean flag = false;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (A[mid] > target) {
                j = mid - 1;
            } else if (A[mid] < target) {
                i = mid + 1;
            } else {
                i = mid; 
                j = mid;
                flag = true;
                break;
            }
        }
        while (i > 0 && A[i - 1] == target) {
            i--;
        }
        while (j < A.length - 1 && A[j + 1] == target) {
            j++;
        }
        if (!flag) return res;
        res[0] = i;
        res[1] = j;
        return res;
    }
}
