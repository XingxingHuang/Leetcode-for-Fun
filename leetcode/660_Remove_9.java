// base 10 to base 9
public class Solution {
    public int newInteger(int n) {
        long[] helper = new long[10];
        long count = 1;
        long m = 10;
        helper[0] = 1;
        for (int i = 1; i < 10; i++) {
            helper[i] = m - count;
            count = m + count * 9;
            m *= 10;
        }
        // System.out.println(Arrays.toString(helper));
        count = 0;
        for (int i = 9; i >= 1; i--) {
            if (n >= helper[i]) {
                int temp = n / (int) helper[i];
                n = n - temp * (int) helper[i];
                count = temp + count;
            }
            // System.out.println(i + " " +  n);
            count = count * 10;
        }
        count = count + n;
        return (int) count;
    }
}

// one line
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }
    
// 
    public int newInteger(int n) {
        int ans = 0;
        int base = 1;
            
        while (n > 0){
            ans += n % 9 * base;
            n /= 9;
            base *= 10;
        }
        return ans;
    }