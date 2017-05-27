public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        n = n % 3;
        if (n == 0) {
            return false;
        }
        return true;
    }
}