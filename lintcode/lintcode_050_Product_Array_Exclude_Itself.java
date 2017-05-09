// https://www.lintcode.com/en/problem/product-of-array-exclude-itself/#
public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int n = A.size();
        ArrayList<Long> B = new ArrayList<Long>();
        long[] f = new long[n];
        long now = 1;
        // 从后往前
        for (int i = n - 1; i >= 0; i--) {
            f[i] = A.get(i);
            if (i < n - 1) {
                f[i] *= f[i + 1];
            }
        }
        // 从前往后
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                B.add(now * f[i + 1]);
            } else {
                B.add(now);
            }
            now *= A.get(i);
        }
        return B;
        
        // 没注意写反了。
        // int n = A.size();
        // ArrayList<Long> B = new ArrayList<Long>();
        // long[] f = new long[n];
        // long now = 1;
        // for (int i = 0; i < n; i++) {
        //     if (i > 0) {
        //         f[i] = now;
        //     } 
        //     now *= A.get(i);
        // }
        // now = 1;
        // for (int i = n - 1; i >= 0; i--) {
        //     B.get(i) = f[i] * now;
        //     if (i < n - 1) {
        //         now *= A[i + 1];
        //     }
        // }
        // return B;
    }
}
