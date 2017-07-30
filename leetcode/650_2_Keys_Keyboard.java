// 2017.07.29 contest 
// DP, memorization type questions. 
public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n * 2];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        for (int i = 1; i <= n; i++) { // 对于第i个元素开始，我们可以进行复制粘贴(k=2)的操作;
            int k = 2;
            // 对每一个i的整数倍的元素，我们只需要复制粘贴（共k=2次），再粘贴(k++);
            
            // for (int j = i * 2; j <= n; j += i) {
            //     dp[j] = Math.min(dp[j], dp[i] + k);
            //     k++;
            // }
            
            int j = i * k;
            while (j <= n) {
                dp[j] = Math.min(dp[j], dp[i] + k);
                k++;
                j = i * k;
            }
        }
        return dp[n];
    }
}

// GardenAAA
public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1000];
        dp[1] = 0;
        // dp[2] = 2;
        // dp[3] = 3;
        for(int i = 2; i <= n; i++) {
            dp[i] = i; // 初始化次数，肯定比i次要小
            for(int j = 2; j <= i / 2; j++) {
                if(i % j == 0) { 
                    dp[i] = Math.min(dp[i], (i / j) + dp[j]);
                }
            }
        }
        return dp[n];
    }
}

// Brute Force method, time exceed.
// public class Solution {
//     public int minSteps(int n) {
//         if (n == 0) {
//             return 0;
//         }
//         if (n == 1) {
//             return 0;
//         }
//         return helper(n, 0, 1, 0);
//     }
//     public int helper(int n, int copy, int cur, int count) {
//         // 到达
//         if (cur == n) {
//             return count;
//         }
//         // 还差几步
//         if (copy > n - count) {
//             return Integer.MAX_VALUE;
//         } 
//         return Math.min(helper(n, copy, cur + copy, count + 1), helper(n, cur, cur, count + 1));
//     }
// }