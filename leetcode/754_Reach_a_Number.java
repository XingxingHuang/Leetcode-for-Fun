// 12.30 Math

class Solution {
    public int reachNumber(int target) {
        if (target == 0) 
            return 0;
        for (int i = 1;; i++) {
            if ( (i + 1)*i/2 - Math.abs(target) >= 0 && ((i + 1)*i/2 - target) % 2 == 0)
                return i;
        }
    }
}