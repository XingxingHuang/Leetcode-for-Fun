// @Author: Xingxing Huang
public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            return result;
        }
        for (int i = 1; i <= 9; i++) {
                result.add(i);
        }
        if (n == 1) {
            return result;
        }
        for (int i : numbersByRecursion(n - 1)) {
            for (int j = 0; j <= 9; j++) {
                result.add(i * 10 + j);
            }
        }
        return result;
    }
}