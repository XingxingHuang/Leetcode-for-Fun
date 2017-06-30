// @Author: Xingxing Huang
// 题目要求的意思是判断是否为1，3，9，27...

// 递归方法，除以三判断
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        }
        return false;
    }
}

// 题目不允许用loop / recursive。那么只能用数学方法。判断是否为3^x，那么计算x是否为整数即可。
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        //return Math.log(n) / Math.log(3) % 1 == 0;   // wrong?!
        return Math.log10(n) / Math.log10(3) % 1 == 0;  
    }
}

// 最简洁的代码, 用最大的3的幂次判断
public class Solution {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n > 0 &&  1162261467 % n == 0);
    }
} 


//https://discuss.leetcode.com/topic/33536/a-summary-of-all-solutions-new-method-included-at-15-30pm-jan-8th