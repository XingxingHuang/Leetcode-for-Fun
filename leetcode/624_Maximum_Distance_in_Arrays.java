/**
 * 题目要求两个数是来自不同的arrays。那么计算到某一行的时候，其最大的差别为
 *   max(之前的最大差值，前面的最大值-这一行最小值，这一行最大值-前面最小值)
 * 这样的计算避免了两个数来自同一行的情形。
 * @author  Xingxing Huang  
 * @since   2017.06.17  
 * @Time    O(n)    
 * @param   int[][]
 * @return  int
 */
public class Solution {
    public int maxDistance(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int diff = Integer.MIN_VALUE;
        // 这里不能设置成max_value, min_value，否则后续加减计算会溢出
        int min = arrays[0][0];
        int max = arrays[0][arrays[0].length - 1]; 
        for (int i = 1; i < arrays.length; i++) {
            int head = arrays[i][0];
            int end = arrays[i][arrays[i].length - 1];
            diff = Math.max(diff, Math.abs(max - head));
            diff = Math.max(diff, Math.abs(end - min));
            max = Math.max(end, max);
            min = Math.min(head, min);
        }
        return diff;
    }
}