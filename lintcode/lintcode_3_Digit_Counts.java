// http://www.lintcode.com/en/problem/digit-counts/
// http://www.jiuzhang.com/solutions/digit-counts/
// 不好分析。参考剑指面试32题
// 或者参考 http://www.cnblogs.com/EdwardLiu/p/4274497.html

// 暴力直接解法 时间复杂度O(n * log n)
class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k);
        }
        return cnt;
    }
    
    public int singleCount(int i, int k) {
        if (i == 0 && k == 0)
            return 1;
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == k) {
                cnt++;
            }
            i = i / 10;
        }
        return cnt;
    }
};

// 与数字相关的题目转化成字符串有时更好求解
class Solution {
    public int digitCounts(int k, int n) {
        int count = 0;
        char kChar = (char)(k + '0');
        for (int i = k; i <= n; i++) {
            char[] iChars = Integer.toString(i).toCharArray();
            for (char iChar : iChars) {
                if (kChar == iChar) count++;
            }
        }

        return count;
    }
}

class Solution {
    /*
     * 当某一位的数字小于i时，那么该位出现i的次数为：更高位数字 x 当前位数。
     *          例如23456 中最高位4出现次数为0次。
                           第二位4出现次数为 2 x 1000次。 
     
     * 当某一位的数字等于i时，那么该位出现i的次数为：更高位数字 x 当前位数 + 低位数字 + 1。 
     *          比如11345，最高位是1. 出现1次数 1345 + 1次
                          第二位是1. 出现1次数 1 x 1000 + 1345 + 1 
                          
     * 当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1) x 当前位数
     *          比如23456，最高位是2，出现1的次数为 10000
                          第二位是3，出现1的次数为 (2 + 1) x 1000
                          
     * !!!! 请考虑k 为 0的特殊情况。
     */
    public int digitCounts(int k, int n) {
        if (k == 0 && n < 10) {
            return 1;
        }
        int count = 0;
        int base = 1;
        while (n / base >= 1) {
            int curBit = n % (base * 10) / base; // 当前数字
            int higher = n / (base * 10);   // 高位数字
            int lower = n % base;   // 低位数字
            if (curBit < k) {
                count += higher * base;
            }
            else if (curBit == k) {
                count += higher * base + lower + 1;
            }
            else {
                count += (higher + 1) * base;
            }
            base *= 10;
        }
        // k = 0的时候在计算10以上的数时，0的个数会被高估。
        if (n > 9 && k == 0) {
            return count - 10;
        }
        return count;
    }
};

