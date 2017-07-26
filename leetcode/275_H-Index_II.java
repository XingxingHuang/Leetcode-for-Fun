/**
 * binary search。边界条件非常注意
 * @author  Xingxing Huang  
 * @since   2017.05.23  
 * @Time    O(n)    
 * @param   int[]
 * @return  int
 */
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // 左边的引用一定小于排名
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] > len - mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return len - lo;
    }
}