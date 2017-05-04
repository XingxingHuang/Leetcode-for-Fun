/**
 * Two Sum 题目，必须记住。
 * @author  Xingxing Huang  
 * @since   2017.04.18
 * @Time    O(n)
 * @param   int
 * @return  int[]
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // if (nums == null) {};
        int[] res = new int[2];
        int end = binarySearch(nums, target);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= end; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i + 1;
                return res;
            }
            map.put(nums[i], i + 1);
        }
        return res;
    }
    
    public int binarySearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            }
            if (nums[m] >= target) {
                j = m - 1;
            }
        }
        return j;
    }
}