// 2017.08.18 Xingxing Huang
O(n)
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
     }
}

// O(logn)
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i + 1 < j) {
            int m = i + (j - i) / 2;
            if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
                return nums[m];
            } else if ((nums[m] == nums[m - 1] && m % 2 == 1) 
                       || ((nums[m] == nums[m + 1] && m % 2 == 0))) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if (i == 0 || nums[i] != nums[i - 1]) 
            return nums[i];
        else
            return nums[j];
    }
}