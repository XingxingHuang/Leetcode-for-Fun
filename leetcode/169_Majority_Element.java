/**
 * 方法巧妙。
 * 有多重解法，并且有进阶问题 229
 * https://discuss.leetcode.com/topic/28601/java-solutions-sorting-hashmap-moore-voting-bit-manipulation
 * @author  Xingxing Huang  
 * @since   2017.05.04
 * @Time    排序方法 O(NlogN), 快速方法O(N) 
 * @param   int[]
 * @return  int
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
            }
            if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}