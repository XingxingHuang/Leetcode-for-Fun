// @Author: Xingxing Huang
// 数论内容
// a^b % c = (a^2)^(b/2) %c
// a^b % c = (a^2)^(b/2)*a %c
// 注意用long 变量，否则数字相乘会溢出
class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        long temp = fastPower(a, b, n >> 1);
        temp = temp * temp % b;
        if ((n & 0x1) == 1) {
            temp = temp * (a % b) % b;
        }
        return (int) temp;
    }
}