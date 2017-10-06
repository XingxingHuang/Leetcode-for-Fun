/**
 * DP, 注意位运算符的优先级很低
 * @author  Xingxing Huang  
 * @since   2017.04.26
 * @Time    O(n*size(num)), O(n);
 * @param   
 * @return  
 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}