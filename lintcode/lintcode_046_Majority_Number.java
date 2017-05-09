// http://www.lintcode.com/en/problem/majority-number/
// 技巧
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int count = 0;
        int candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                count++;
                candidate = nums.get(i);
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}