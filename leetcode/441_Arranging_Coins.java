// binary search 
public class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }
}


// Math
public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}


// O(n)
class Solution {
    public int arrangeCoins(int n) {
        for (int i = 0; i <= n + 1; i++) {
            if (n < (i*(i+1) / 2))  return i - 1;
        }
        return 0;
    }
}

