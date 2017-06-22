// http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = 1;
        int ans = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                ans++;
                max = Math.max(max, ans);
            } else {
                ans = 1;
            }
        }
        for (int i = A.length - 2; i >=0; i--) {
            if (A[i] < A[i + 1]) {
                ans++;
                max = Math.max(max, ans);
            } else {
                ans = 1;
            }
        }
        return max;
    }
}

// // 代码错误，题目并没有要求是连续的递增或递减
// public class Solution {
//     /**
//      * @param A an array of Integer
//      * @return  an integer
//      */
//     public int longestIncreasingContinuousSubsequence(int[] A) {
//         // Write your code here
//         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for (int i = 0; i < A.length; i++) {
//             if (map.containsKey(A[i])) {
//                 continue;
//             }
//             if (map.containsKey(A[i] + 1)) {
//                 map.put(A[i], map.get(A[i] + 1) + 1);
//                 int j = A[i] - 1;
//                 while (map.containsKey(j)) {
//                     map.put(j, map.get(A[i]) + j - A[i]);
//                     j--;
//                 }
//             } else {
//                 map.put(A[i], 1);
//             }
//         }
//         int max = 0;
//         for (int key : map.keySet()) {
//             max = Math.max(max, map.get(key));
//         }
//         return max;
//     }
// }