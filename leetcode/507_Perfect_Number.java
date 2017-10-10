class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;
        int sum = 0;
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i*i != num) 
                    sum += num / i;
            }
        }
        return sum - num == num;
    }
}

// Euclid proved that 2p−1(2p−1)2p−1(2p−1) is an even perfect number whenever 2p−12p−1 is prime, where pp is prime.
public class Solution {
    public int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
    public boolean checkPerfectNumber(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime: primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }
}