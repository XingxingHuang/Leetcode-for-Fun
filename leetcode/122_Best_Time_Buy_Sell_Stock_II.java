/*
   @Author: Xingxing Huang
   @Time: O(N)
   @Date: 2017/03/27
   @思路: 比较相邻的值，如果减小，那么这个profit我们肯定能够获得。
          对于递减的序列，由于只能买卖一次，获得的最大收益就是头尾的价格差
   @相关链接: 股票系列题的分析  https://sophiesongge.github.io/leetcode/2017/02/15/buy-sell-stock.html
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}