// 10.07
class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean isOne = (n & 1) == 1;
        while (n != 0) {
            n = n >> 1;
            if ((n & 1) == 1 && isOne) 
                return false;
            else if ((n & 1) == 0 && !isOne)
                return false;
            isOne = !isOne;
        }
        return !isOne;
    }
}