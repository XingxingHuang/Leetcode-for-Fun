/** @Author: Xingxing Huang
  * @Time: O(nlogn) and O(n)
  * @Date: 2017.04.06
  * http://www.jiuzhang.com/solutions/wiggle-sort/
  */

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void  wiggleSort(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i+=2) {
            int temp = nums[i-1];
            nums[i-1] = nums[i];
            nums[i] = temp;
        }
    }
}

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void  wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 如果是奇数那么应该大于于前一个数，如果是偶数，那么应该小于前一个数
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || 
                (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}