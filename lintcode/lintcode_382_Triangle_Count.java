/** http://www.lintcode.com/en/problem/triangle-count/
 * two sum 的following up问题。
 * 三角形条件是任意两条边和大于第三边即可。
 * 排序数组之后我们可以把条件降为一个，前两个指标的元素和大于第三个元素，
 * 这样就转化为two sum的问题。
 * 暴力解法 O(n^3), 优化解法 O(n^2)
 */

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length == 0) {
            return 0;
        }
        Arrays.sort(S);
        int count = 0;
        for (int i = 0; i < S.length; i++) { // target = S[i];
            int m = 0;
            int n = i - 1;
            while (m < n) { // m + n 元素和 > target 
                if (S[m] + S[n] > S[i]) {
                    count += n - m;
                    n--;
                } else {
                    m++;
                }
            }
        }
        return count;
    }
}

// 代码稍微不是很简洁。
public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length == 0) {
            return 0;
        }
        Arrays.sort(S);
        int count = 0;
        for (int i = 0; i < S.length; i++) { // target = S[i];
            for (int n = i - 1; n >= 0; n--) {
                int m = 0;
                while (m < n) { // m + n 元素和 > target 
                    if (S[m] + S[n] > S[i]) {
                        count += n - m;
                        break;
                    } else {
                        m++;
                    }
                }
            }
        }
        return count;
    }
}
