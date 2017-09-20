// 09/20
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else if (mid + 1 > x/(mid + 1)) {
                return mid;
            } else {                
                left = mid + 1;
            }
        }    
    }
}

// Newton method
// https://discuss.leetcode.com/topic/24532/3-4-short-lines-integer-newton-every-language
    long r = x;
    while (r*r > x)
        r = (r + x/r) / 2;
    return (int) r;