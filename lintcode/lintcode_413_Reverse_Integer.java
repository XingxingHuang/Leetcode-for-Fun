/**
 * http://www.lintcode.com/en/problem/reverse-integer/?favoriteListName=bit#
 * 注意考虑一下情况：
 *    overflow，0， 
 */
public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        int res = 0;
        while (n != 0) {
            int tmp = res*10 + n % 10;
            n = n / 10;
            if (tmp/10 != res) {
                return 0;
            }
            res = tmp;
        }
        return res;
    }
}