// @Author: Xingxing Huang
// @Date: 2017/03/27
// Time: O(N^2). Time Limit Exceeded
// 从右到左计算sellprice，从左到右计算buyprice。就算buy-sell计算出收益最大值。
// 有许多重复计算。
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int largest = 0;
        for (int j = prices.length - 1; j > 0; j--) {
            // System.out.printf("%d %d", j, prices[j]);
            int sellprice = prices[j];
            if (sellprice < prices[j]) sellprice = prices[j];
            int buyprice = prices[0]; 
            for (int i = 0; i < j; i ++) {
                if (buyprice > prices[i]) buyprice = prices[i];
                }
            if (largest < sellprice - buyprice) largest = sellprice - buyprice;
        }
        if (largest >0) return largest;
        return 0;
    }
}

// Time: O(N)
// 从左至右，计算每次如果卖出的话可以得到的收益。即前面收益+(前一个价格-当前价格)，价格增加的话收益归0
// 最终的收益就是所有点计算收益的最大值。
// 有点点类似最大栈结构的思想，也就是说每次不直接计算最终结果，而只计算中间一部的值
public class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);  // 赋值操作在括号里面
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
