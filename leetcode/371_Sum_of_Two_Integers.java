// 2017.8.13 XingxingHuang
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = (a & b); // 需要进位的位,  1 & 1 ---> 1
            a = a ^ b;   // 0 ^ 1 ---> 1    1 ^ 0 ---> 1
            b = c << 1;  // 更新进位
        }
        return a;
    }
}

