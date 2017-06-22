// http://www.lintcode.com/en/problem/copy-books/
// 想想k=2的时候如何计算，可以联想到binary search。但是如何推广到k=3的情况呢
// 这是一个最大值最小化的问题，可以考虑一个新问题，能否划分成k个序列，每个序列的和均不大于某个值 (即最大值的最小化)。
// 有了这个思路，可以在max ~ sum 之间用二分方法，找到这个值。
// 每次二分后搜索复杂度为线性，因此总复杂度为O(n * log m)


public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        // corner case
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int n = pages.length;
        k = k > n ? n : k;
        // prepare for the binary search
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pages[i];
            max = Math.max(max, pages[i]);
        }
        // use binary search template
        int l = max;
        int u = sum;
        while (l + 1 < u) {
            int mid = l + (u - l) / 2;
            if (valid(pages, mid, k)) {
                u = mid;
            } else {
                l = mid;
            }
        }
        if (valid(pages, l, k)) {
            return l;
        }
        return u;
    }
    private boolean valid(int[] pages, int value, int k) {
        // 判断是否可以分割成k份，每份值不大于value
        int n = pages.length;
        int sum = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            sum += pages[i];
            if (sum > value) {
                num++;
                sum = pages[i];
            } 
        }
        if (num <= k) {
            return true;
        }
        return false;
    }
}


// 九章答案
//http://www.jiuzhang.com/solution/copy-books/
// version 1: Binary Search
// this version cost O(n log m) where n is the number of books and m is the sum of the pages.
public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages.length == 0) {
            return 0;  
        }
        
        int total = 0;
        int max = pages[0];
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (max < pages[i]) {
                max = pages[i];
            }
        }
        
        int start = max;
        int end = total;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (countCopiers(pages, mid) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (countCopiers(pages, start) <= k) {
            return start;
        }
        
        return end;
    }
    
    private int countCopiers(int[] pages, int limit) {
        if (pages.length == 0) {
            return 0;
        }
        
        int copiers = 1;
        int sum = pages[0]; // limit is always >= pages[0]
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }
        
        return copiers;
    }
}

// version 2: Dynamic Programming
// O(n * k)
// dp[i][j]  表示对前面的i+1个book 分成j+1份的最大的最小值。
// 初始dp[i][0] 为前面i号书的累加和 dp[0][j] 为第一本书的值
// 递推关系为
//      f[i][j] = Math.max(f[i-1][j], pages[i])
// 需要注意的是j>i的情况
public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages == null){
            return 0;
        }
        int n = pages.length;
        if (n == 0){
            return 0;
        }
           
        if (k > n) {
            k = n;
        }
        int[] sum = new int[n];
        sum[0] = pages[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i-1] + pages[i];
        }
        int[][] f = new int[n][k];
        for (int i=0; i<n; ++i) f[i][0] = sum[i];
        for (int j=1; j<k; ++j) {
            int p = 0;
            f[0][j] = pages[0];
            // 状态转移方程
            for (int i = 1; i < j; ++i) {
                f[i][j] = Math.max(f[i-1][j], pages[i]); 
            }
            for (int i = j; i < n; ++i) {
                while (p < i && f[p][j-1] < sum[i] - sum[p]) ++p;
                f[i][j] = Math.max(f[p][j - 1], sum[i] - sum[p]);                
                if (p > 0) {
                    --p;
                }
                f[i][j] = Math.min(f[i][j], Math.max(f[p][j - 1], sum[i] - sum[p]));         
            }
        }
        return f[n - 1][k - 1];
    }
}
