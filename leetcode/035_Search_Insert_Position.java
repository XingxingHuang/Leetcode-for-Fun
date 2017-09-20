// 09.20 binary search
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0; 
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] > target) 
                j = m - 1;
            else  
                i = m + 1;
        }
        return i;
    }
}

// another 
public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length;
    while(low < high) {
        int mid = low + (high - low) / 2;
        if(nums[mid] < target)
            low = mid + 1;
        else
            high = mid;
    }
    return low;
}


// template binary search
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}



class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0; 
        int j = nums.length - 1;
        while (i + 1 < j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) 
                return m;
            else if (nums[m] > target)
                j = m - 1;
            else
                i = m + 1;
        }
        if (nums[i] == target)
            return i;
        else if (nums[j] == target)
            return j;
        else if (nums[j] < target)
            return j + 1;
        else if (nums[j] < target)
            return i + 1;
        else 
            return i;
    }
}
