// @Author: Xingxing Huang
public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        int[] helper = new int[128];
        for (char i : A.toCharArray()) {
            helper[i - ' ']++;
        }
        for (char i : B.toCharArray()) {
            helper[i - ' ']--;
        }
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] != 0) {
                return false;
            }
        }
        return true;
    }
}