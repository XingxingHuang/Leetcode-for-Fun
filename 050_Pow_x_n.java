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


public class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.;
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        double pow = myPow(x, n / 2);
        return (n % 2 == 0) ? pow * pow : x * pow * pow;
    }
}