// http://www.lintcode.com/en/problem/sqrtx-ii/
// 注意case为1的情况, 小于1的情况。精度的处理

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        if (x == 0) {
            return 0;
        }
        double l = 1.;
        double r = x;
        if (r > 65535) {
            r = 65536;
        }
        if (x < 1.) {
            l = x;
            r = 1.;
        }
        while (r - l >= 1.e-9) { // 注意精度比结果要高
            double m = (l + r) / 2.;
            if (m * m > x) {
                r = m;
            } else if (m * m < x){
                l = m;
            } else {
                return m;
            }
        }
        // // 注意x=1
        // if (Math.abs(r * r - x) > Math.abs(l * l - x)) {
        //     return l;
        // }
        return r;
    }
}


// 九章： http://www.jiuzhang.com/solution/sqrtx-ii/
//Solution2 : 牛顿法
public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double res = 1.0;
        double eps = 1e-12;

        while(Math.abs(res * res - x) > eps) {
            res = (res + x / res) / 2;
        }

        return res;
    }
}