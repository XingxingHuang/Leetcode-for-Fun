// https://www.lintcode.com/en/problem/maximum-subarray-iii/
// 这套题思路有了，但是没有亲自代码实现，只修改了网站代码。遇到时请重新编写！！！
// 思路： 从k=2的题目开始思考，如果我知道0-i的部分数组的k-1个subarray和的最大值，那么结合后续的数组中的一个subarray最大值，就可以组成最大的k个subarray。这时候我们遍历所有的i的情况就可以了。然后对于k的值我们也进行一次遍历。顺着这个思路我们可以做一个dp[k][n]的数组，第一维度表示计算k个subarray，值从1到k，第二维度代表数组指标，从0到n-1。但是注意到必须大于第一维度的值。因此实际指标是从k-1到n-1。
// public class Solution {
//     /**
//      * @param nums: A list of integers
//      * @param k: An integer denote to find k non-overlapping subarrays
//      * @return: An integer denote the sum of max k non-overlapping subarrays
//      */
//     public int maxSubArray(int[] nums, int k) {
//         // write your code here
//         if (nums == null || nums.length < k) {
//             return 0;
//         }
//     }
// }

//  http://www.cnblogs.com/lishiblog/p/4183917.html
// 我给网页中的代码进行了代码风格上的优化。
// 网页中提供的代码里面包含一个空间优化的结果。
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int len = nums.length;
        //d[i][j]: select j subarrays from the first i elements, the max sum we can get.
        int[][] d = new int[len + 1][k + 1]; // 第0个元素没用

        for (int j = 1; j <= k; j++)  // j表示k个数组
            for (int i = j ; i <= len; i++){ // i表示数组下标(0-len)，从j开始计算。
                d[i][j] = Integer.MIN_VALUE;
                int sum = 0;
                int max = Integer.MIN_VALUE;                
                for (int ii = i - 1; ii >= j - 1; ii--){  
                    // 余下数组j-1 到 i-1元素 选出最大和
                    sum = Math.max(nums[ii], sum + nums[ii]);
                    max = Math.max(sum, max);
                    d[i][j] = Math.max(d[i][j], d[ii][j - 1] + max);   
                }
            }
        return d[len][k];
    }
}


// http://www.jiuzhang.com/solutions/maximum-subarray-iii/
// 这个解法比较复杂。暂时忽略。修改了输入为int[]
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */ 
    public static int maxSubArray(int[] nums, int k) {
        // write your code
        int len = nums.length;
        int[][] f = new int[k+1][len];
        // 初始化，前面i个数单独分成k-1个数组，后面的数组中计算最大值的情况
        for (int i = 1; i < k+1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }
            f[i][i-1] = sum;
        }
        // 前面1个元素构成单独数组，后面构成k-1个数组的情况
        for (int i = 1; i < len; i++) {
            f[1][i] = Math.max(f[1][i-1]+nums[i], nums[i]);
        }
        
        // 与上面一个代码同理，但是这里第三重循环是从小到大。需要用到上面初始化的结果。
        for (int i = 2; i < k+1; i++) {
            for (int n = i;  n< len; n++) {
                int curMax = f[i][n-1] + nums[n];
                for (int j = i-2; j < n; j++) {
                    if ((f[i-1][j] + nums[n]) > curMax) {
                        curMax = f[i-1][j] + nums[n];
                    }
                }
                f[i][n] = curMax;
            }
        }
        
        // 从所有的结果中找到最大值。实际上可以在上面三重循环中计算。
        int res = Integer.MIN_VALUE;
        for (int i = k-1; i < len; i++){
            if (f[k][i] > res) {
                res = f[k][i];
            }
        }
        return res;
    }
}