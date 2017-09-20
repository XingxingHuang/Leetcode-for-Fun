// 2017.09.14
// to add n-1 by 1 also equals substract 1 from one element.
class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
        }
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }
}

// Math: 
// sum + (n - 1)* res = x * n
// x = min + res;
// sum = min * n + res
// res = sum - min*n
class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : nums) {
            min = Math.min(min, n);
            sum += n;
        }
        return sum - min * nums.length;
    }
}
