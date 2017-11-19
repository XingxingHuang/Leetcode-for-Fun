// 11.19 
// easy, brute force
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            boolean flag = true;
            int orig = num;
            while (orig > 0) {
                int n = orig % 10;
                if (n == 0 || num % n != 0) {
                    flag = false;
                    break;
                } 
                orig = orig / 10;
            }
            if (flag) res.add(num);
        }
        return res;
    }
}