// http://www.lintcode.com/en/problem/continuous-subarray-sum/
// 注意题目要求返回的是坐标，注意index的存储。
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= max) {
                max = sum;
                start = j;
                end = i;
            } 
            if (sum < 0) {
                sum = 0;
                j = i + 1;
            }
            
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(start);
        res.add(end);
        return res;
    }
}


// 九章代码：
// http://www.jiuzhang.com/solutions/continuous-subarray-sum/
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);

        int len = A.length;
        int start = 0, end = 0;
        int sum = 0;
        int ans = -0x7fffffff;
        for (int i = 0; i < len; ++i) {
            if (sum < 0) {
                sum = A[i];
                start = end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (sum >= ans) {
                ans = sum;
                result.set(0, start);
                result.set(1, end);
            }
        }
        return result;
    }
}
