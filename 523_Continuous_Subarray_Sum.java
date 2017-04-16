/**
 * a. 最简单的办法，当然是暴力破解，O(n2)，空间复杂度是O(1)
 * b. 当然这道题可以用动态规划的思路去做，但是实现的时会发现时间复杂度接近O(n2)，而空间复杂度比暴力破解更糟糕，会是O(n)
 * c. 数学的方法：遍历累加，并求出当前和除以k后的余数，记录出现余数的下标。如果同一个余数出现了两次，并且两次出现的下标之差大于1，那么就表示在这两个坐标之间的元素之和是k的倍数。
 * 注意 corner case: [0,0] 0, [1, 2] 0
 * @athor   Xingxing Huang
 * @since   2017.04.14
 * @Time    O(n), O(k)
 * @param   int[], int
 * @return  boolean
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else if (i - map.get(sum) > 1){
                return true;
            }
        }
        return false;
    }
}