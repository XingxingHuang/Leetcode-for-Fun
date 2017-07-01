// http://www.lintcode.com/en/problem/continuous-subarray-sum-ii/

// two pass, 可以第一轮找数组中最大值，第二轮找到数组中最小值，然后总数减去最小值，挑选两个中的最大值。
public class Solution {
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        res.add(0);
        res.add(0);
        // first pass
        int max = Integer.MIN_VALUE;
        int total = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            total += A[i];
            sum += A[i];
            if (sum > max) {
                res.set(0, start);
                res.set(1, i);
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        // second pass
        sum = 0;
        start = 0;
        end = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            if (total - sum > max) {
                // avoid the duplicates with the first pass;
                if (i + 1 == len || start == 0) {
                    continue;
                }
                res.set(0, i + 1);
                res.set(1, (start - 1 + len) % len);
                max = total - sum;
            }
            if (sum > 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return res;
    }
}



// // 注意这个代码错误，当index 0 ~ n-1已经找到一个当前最大值时会停止。
// public class Solution {
//     /**
//      * @param A an integer array
//      * @return  A list of integers includes the index of the first number and the index of the last number
//      */
//     public ArrayList<Integer> continuousSubarraySumII(int[] A) {
//         // Write your code here
//         ArrayList<Integer> res = new ArrayList<>();
//         if (A == null || A.length == 0) {
//             return res;
//         }
//         res.add(0);
//         res.add(0);
//         int max = Integer.MIN_VALUE;
//         int i = 0;
//         int j = 0;
//         int len = A.length;
//         if (len == 1) {
//             return res;
//         }
//         int sum = 0;
//         boolean firstpass = true; // 记录是否到环了。
//         while (j != i || firstpass) { // 即没有转一圈
//             // sum
//             sum += A[j];
//             // judge
//             if (sum > max) {
//                 max = sum;
//                 res.set(0, i);
//                 res.set(1, j);
//             }
//             if (sum < 0) {
//                 sum = 0;
//                 i = j + 1;
//             } 
//             // next index;
//             j++;
//             if (j >= len) {
//                 firstpass = false;
//                 j = j % len;
//             }
//         }
//         return res;
//     }
// }

// 错误！当一轮的逻辑已经很复杂的时候，需要考虑重新拆分任务，整理思路。
// public class Solution {
//     /**
//      * @param A an integer array
//      * @return  A list of integers includes the index of the first number and the index of the last number
//      */
//     public ArrayList<Integer> continuousSubarraySumII(int[] A) {
//         // Write your code here
//         ArrayList<Integer> res = new ArrayList<>();
//         if (A == null || A.length == 0) {
//             return res;
//         }
//         res.add(0);
//         res.add(0);
//         int max = Integer.MIN_VALUE;
//         int i = 0;
//         int j = 0;
//         int len = A.length;
//         if (len == 1) {
//             return res;
//         }
//         int sum = 0;
//         boolean firstpass = true; // 记录是否到环了。
//         while (i < len && (firstpass || j < i)) { // 即i没有全部走完，并且也没有检查完一整圈
//             // sum
//             sum += A[j];
//             // judge
//             if (sum > max) {
//                 max = sum;
//                 res.set(0, i);
//                 res.set(1, j);
//             }
//             if (sum < 0) {
//                 sum = 0;
//                 // System.out.println(" " + i+" "+j);
//                 if (firstpass && j + 1 < len) {
//                     i = j + 1;
//                 }
//                 if (i + 1 < len) {
//                     i++;
//                     j = i;
//                 }   
//             } 
//             // next index;
//             j++;
//             if (j >= len) {
//                 firstpass = false;
//                 j = j % len;
//             }
//         }
//         return res;
//     }
// }


// // 九章代码：
// // http://www.jiuzhang.com/solution/continuous-subarray-sum-ii/
// public class Solution {
//     /**
//      * @param A an integer array
//      * @return  A list of integers includes the index of the first number and the index of the last number
//      */
//     public ArrayList<Integer> continuousSubarraySumII(int[] A) {
//         // Write your code here
//         ArrayList<Integer> result = new ArrayList<Integer>();
//         result.add(0);
//         result.add(0);
//         int total = 0;
//         int len = A.length;
//         int start = 0, end = 0;
//         int local = 0;
//         int global = -0x7fffffff;
//         for (int i = 0; i < len; ++i) {
//             total += A[i];
//             if (local < 0) {
//                 local = A[i];
//                 start = end = i;
//             } else {
//                 local += A[i];
//                 end = i;
//             }
//             if (local >= global) {
//                 global = local;
//                 result.set(0, start);
//                 result.set(1, end);
//             }
//         }
//         local = 0;
//         start = 0;
//         end = -1;
//         for (int i = 0; i < len; ++i) {
//             if (local > 0) {
//                 local = A[i];
//                 start = end = i;
//             } else {
//                 local += A[i];
//                 end = i;
//             }
//             if (start == 0 && end == len-1) continue;
//             if (total - local >= global) {
//                 global = total - local;
//                 result.set(0, (end + 1) % len);
//                 result.set(1, (start - 1 + len) % len);
//             }
//         }
//         return result;
//     }
// }
