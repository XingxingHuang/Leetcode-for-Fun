class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}

// four different methods
// https://leetcode.com/problems/power-of-two/discuss/
// Iterative
// Recursive
// Bit operation
// Math derivation
