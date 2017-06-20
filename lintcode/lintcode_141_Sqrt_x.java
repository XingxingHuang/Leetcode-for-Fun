// http://www.lintcode.com/en/problem/sqrtx/

// 二分法
// 注意的情况，0，太大的数，相乘会溢出。

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x == 0) {
            return 0;
        }
        int l = 1;
        int r = x;
        if (r > 46340) {
            r = 46340;
        } 
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (m * m == x) {
                return m;
            } else if (m * m > x) {
                r = m;
            } else {
                l = m;
            }
        }
        if (r * r < x) {
            return r;
        }
        return l;
    }
}


// http://www.jiuzhang.com/solution/sqrtx/
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}