// 9.20
// 1 is not a prime number, 质数
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (dp[i]) continue;
            count++;
            for (int j = 2; j*i < n; j++) {
                dp[i*j] = true;
            }
        }
        return count;
    }
}


public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}