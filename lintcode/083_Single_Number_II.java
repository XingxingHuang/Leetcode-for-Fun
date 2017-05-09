// http://www.lintcode.com/en/problem/single-number-ii/
// http://www.jiuzhang.com/solutions/single-number-ii/

public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            // 计算出结果数字上每一位的数字
            for(int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }
            // 添加每一位的数字
            result |= (bits[i] << i);
        }
        return result;
    }
}