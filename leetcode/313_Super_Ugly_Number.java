// check : https://discuss.leetcode.com/topic/34841/java-three-methods-23ms-36-ms-58ms-with-heap-performance-explained
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] == ugly[i]) 
                    idx[j]++;
            }
        }

        return ugly[n - 1];
    }
}
