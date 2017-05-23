// http://www.lintcode.com/en/problem/partition-array/
public class Solution {
    /*
     * @param : The integer array you should partition
     * @param : An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] >= k) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        // 注意终止的判断。
        if (nums[i] >= k) {
            return i;
        }
        return i + 1;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};