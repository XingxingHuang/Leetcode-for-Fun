// @Author: Xingxing Huang
// @Time: substring方法的时间复杂度为O(N)，因此该DP方法复杂度高
// @Date: 2017/03/26
// 动态规划求解，从第一个元素开始，如果包含该元素的之前字符串能分割成word，该位置设置为true。如果最后一位为true，那么返回true
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] f = new Boolean[s.length() + 1];  // 长度+1
        f[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            // 对i位置前面的字符串进行扫描
            for (int j = 0; j < i; j++) {  
                if (f[j] && wordDict.containskey(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}


