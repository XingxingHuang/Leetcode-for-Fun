public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (ans[nums[i]] == 1) {
                res[0] = nums[i];
            } else {
                ans[nums[i]] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (ans[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}