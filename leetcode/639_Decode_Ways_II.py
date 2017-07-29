## WRONG answer: "*1*1*0" like that.   patterns like '*0' makes things more complicated.
class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        dp = [1]
        if '0' <= s[0] <= '9':
            dp.append(1)
        else:
            dp.append(9)
        for i in range(1, len(s)):
            if s[i] == '0':
                if (s[i - 1] == '*'):
                    dp.append(dp[i - 1]*2)  # 前面的*只能是1或者2.
                dp.append(dp[i])  # 只能和前面一个元素拼起来
            elif '0' < s[i] <= '9':
                if s[i - 1] == '1' or (s[i - 1] == '2' and s[i] <= '6'):
                    dp.append(1 + dp[i])   # 可以去前一个元素拼起来
                elif s[i - 1] == '*':
                    dp.append(dp[i] + dp[i - 1]*2)   # 可以去前一个元素中 1和2 拼起来
                else:
                    dp.append(dp[i])  # 不能拼
            elif s[i] == '*':
                if s[i - 1] == '0':
                    dp.append(9)  
                elif s[i - 1] == '1':
                    dp.append(dp[i]*9 + dp[i - 1] * 9)  # 单独一个，或者与前面的1结合在一起
                elif s[i - 1] == '2':
                    dp.append(dp[i]*9 + dp[i - 1] * 6)  # 单独一个，或者与前面的2结合在一起
                elif s[i - 1] == '*':
                    dp.append(dp[i]*9 + dp[i - 1] * (15)) # 后面一个括号里面包含前一个*代表 0，1，2，其它对应的情况数, 应该是15 考虑特殊情况
                else:
                    dp.append(9)
            print dp
        return dp[-1]