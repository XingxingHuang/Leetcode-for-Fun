public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long m = (low + high) >>> 1;
            if (m*m > num) high = (int) m - 1;
            if (m*m < num) low = (int) m + 1;
            if (m*m == num) return true;
        }
        return false;
    }
}