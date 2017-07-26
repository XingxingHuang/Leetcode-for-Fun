// must check solutions:
// https://discuss.leetcode.com/topic/21837/5-different-choices-when-talk-with-interviewers
// // wrong answer !!!
// public class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0) {
//             return 1.;
//         }
//         double ans = 1;
//         for (int i = 0; i < Math.abs(n); i++) {
//             ans *= x;
//         }
//         if (n < 0) return 1./ans;
//         return ans;
//     }
// }

// better solution with lower time complexity
// cannot pass: 2, -2147483648
// public class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0)
//             return 1.;
//         if (n < 0){
//             n = -n;
//             x = 1/x;
//         }
//         return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
//     }
// }

// http://www.jiuzhang.com/solutions/powx-n/
// 出错
// public class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0) {
//             return 1;
//         }

//         if (n == 1) {
//             return x;
//         }

//         boolean isNegative = false;
//         if (n < 0) {
//             isNegative = true;
//             n *= -1;
//         }

//         int k = n / 2;
//         int l = n - k * 2;
//         double t1 = myPow(x, k);
//         double t2 = myPow(x, l);
//         if (isNegative) {
//             return 1/(t1*t1*t2);
//         } else {
//             return t1*t1*t2;
//         }
//     }
// }

// public  class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0) 
//             return 1;
//         long ln = (long) n;
//         if (n < 0) 
//             n = -n;
//         double tmp = myPow(x, n / 2);
//         double res = (n % 2 == 0) ?  1./ (tmp * tmp) : 1./ (x * tmp * tmp);
//         return res;
//     }
// }

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.;
        if (x == 0) 
            return 0.;
        if (x == 1) 
            return 1.;
        if (n < 0) 
            return 1 / myPow(x, -(n + 1)) / x;
        double res = myPow(x, n / 2);
        return res * res * (n % 2 == 0 ? 1 : x);
    }
}