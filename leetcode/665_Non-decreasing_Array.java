class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 2) 
            return true;
        for (int i = 0; i < nums.length; i++) {
            int pre = Integer.MIN_VALUE;
            int j = 0;
            while (j < nums.length) {
                if (j == i) {
                    j++;
                    continue;
                }
                if (nums[j] < pre) break;
                pre = nums[j];
                j++;
            }
            if (j == nums.length) return true;
        }
        return false;
    }
}


// O(n) solution
// find the first ascend two. then check which one should be modified.
class Solution {
    public boolean checkPossibility(int[] a) {
        boolean modified = false;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                if (modified) return false;
                if (i - 2 < 0 || a[i - 2] <= a[i]) 
                    a[i - 1] = a[i]; // lower a[i - 1]
                else 
                    a[i] = a[i - 1]; // rise a[i]
                modified = true;
            }
        }
        return true;
    }
}