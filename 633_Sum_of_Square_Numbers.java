// 注意溢出的情况，
// 记忆化的思想
public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c  == 0 || c == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<Integer>();
        int max = (int) Math.sqrt(2000000000);
        for (int i = 0; i < c && i < max; i++) {
            if (i * i > c) 
                break;
            set.add(i * i);
        }
        for (int i : set) {
            if (i > c) 
                break;
            if (set.contains(c - i)) {
                return true;
            }
        }
        return false;
    }
}