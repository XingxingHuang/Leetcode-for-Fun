// 11.30
// DP解法 非空间压缩，内存溢出
class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) 
            return true;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n; i++) {
            dp[i] = 0;
            for (int j = 0; j < 3; j++) {
                // 如果对方有机会肯定输，那么我就可以赢。
                if (dp[i - j - 1] == 0) dp[i] = 1;
            }
        }
        return dp[n - 1] == 1;
    }
}

// DP解法 空间压缩, 超时
class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) 
            return true;
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) 
            dp[i] = 1;
        int target = 1;
        for (int i = 3; i < n; i++) {
            target = 0;
            for (int j = 0; j < 3; j++) {
                // 如果对方有机会肯定输，那么我就可以赢。
                if (dp[j] == 0) target = 1;
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = target;
        }
        return target == 1;
    }
}


// DP解法 空间压缩, 时间压缩，仍然超时
class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) 
            return true;
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) 
            dp[i] = 1;
        int target = 1;
        for (int i = 3; i < n; i++) {
            target = 0;
            for (int j = 0; j < 3; j++) {
                // 如果对方有机会肯定输，那么我就可以赢。直接跳过三个，节省时间。
                if (dp[j] == 0) {
                    target = 1;
                    dp[j] = 1;
                    i += 2; // 一共跳过三个
                }
            }
            dp[2] = target;
        }
        return target == 1;
    }
}

// 博弈经典题目。如果是4的倍数，无论如何你选多少，对方都可以选4-x，保证最后胜利。
// class Solution {
//     public boolean canWinNim(int n) {
//         return (n % 4 != 0);
//     }
// }

