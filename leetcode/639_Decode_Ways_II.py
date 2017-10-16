# Let's keep track of:
# e0 = current number of ways we could decode, ending on any number;
# e1 = current number of ways we could decode, ending on an open 1;
# e2 = current number of ways we could decode, ending on an open 2;
class Solution(object):
    def numDecodings(self, S):
        MOD = 10**9 + 7
        e0, e1, e2 = 1, 0, 0
        for c in S:
            if c == '*':
                f0 = 9*e0 + 9*e1 + 6*e2
                f1 = e0
                f2 = e0
            else:
                f0 = (c > '0') * e0 + e1 + (c <= '6') * e2
                f1 = (c == '1') * e0
                f2 = (c == '2') * e0
            e0, e1, e2 = f0 % MOD, f1, f2
        return e0
# # TLE
# class Solution(object):
#     def numDecodings(self, s):
#         """
#         :type s: str
#         :rtype: int
#         """
#         if len(s) == 0:
#             return 0
#         # init status
#         MOD = 10**9 + 7
#         dp = [1]
#         if '1' <= s[0] <= '9':
#             dp.append(1)
#         elif s[0] == '0':
#             dp.append(0)
#         else:
#             dp.append(9)
#         # loop for the situations
#         for i in range(1, len(s)):
#             if s[i] == '0':
#                 if (s[i - 1] == '*'):
#                     dp.append(dp[i - 1]*2)  # 前面的*只能是1或者2.
#                 elif '1' <= s[i - 1] <= '2':
#                     dp.append(dp[i-1])  # 只能和前面一个元素拼起来
#                 else:
#                     dp.append(0)
#             elif '0' < s[i] <= '9':
#                 if s[i - 1] == '1' or (s[i - 1] == '2' and s[i] <= '6'):
#                     dp.append(dp[i - 1] + dp[i])   # 可以去前一个元素拼起来
#                 elif s[i - 1] == '*':
#                     if '0' < s[i] <= '6':
#                         dp.append(dp[i] + dp[i - 1]*2)   # 可以去前一个元素中 1和2 拼起来
#                     else:
#                         dp.append(dp[i] + dp[i - 1])
#                 else:
#                     dp.append(dp[i])  # 不能拼
#             elif s[i] == '*':
#                 if s[i - 1] == '0':
#                     dp.append(9 * dp[i])  
#                 elif s[i - 1] == '1':
#                     dp.append(dp[i]*9 + dp[i - 1] * 9)  # 单独一个，或者与前面的1结合在一起
#                 elif s[i - 1] == '2':
#                     dp.append(dp[i]*9 + dp[i - 1] * 6)  # 单独一个，或者与前面的2结合在一起
#                 elif s[i - 1] == '*':
#                     dp.append(dp[i]*9 + dp[i - 1] * (15)) # 后面一个括号里面包含前一个*代表 1，2，其它对应的情况数, 应该是15 考虑特殊情况
#                 else:
#                     dp.append(dp[i]*9)
#             # print dp
#         return dp[-1] % MOD
    
# ## WRONG answer: "*1*1*0" like that.   patterns like '*0' makes things more complicated.
# ## should consider more corner cases.
# class Solution(object):
#     def numDecodings(self, s):
#         """
#         :type s: str
#         :rtype: int
#         """
#         if len(s) == 0:
#             return 0
#         dp = [1]
#         if '1' <= s[0] <= '9':
#             dp.append(1)
#         else:
#             dp.append(9)
#         for i in range(1, len(s)):
#             if s[i] == '0':
#                 if (s[i - 1] == '*'):
#                     dp.append(dp[i - 1]*2)  # 前面的*只能是1或者2.
#                 dp.append(dp[i])  # 只能和前面一个元素拼起来
#             elif '0' < s[i] <= '9':
#                 if s[i - 1] == '1' or (s[i - 1] == '2' and s[i] <= '6'):
#                     dp.append(1 + dp[i])   # 可以去前一个元素拼起来
#                 elif s[i - 1] == '*':
#                     dp.append(dp[i] + dp[i - 1]*2)   # 可以去前一个元素中 1和2 拼起来
#                 else:
#                     dp.append(dp[i])  # 不能拼
#             elif s[i] == '*':
#                 if s[i - 1] == '0':
#                     dp.append(9)  
#                 elif s[i - 1] == '1':
#                     dp.append(dp[i]*9 + dp[i - 1] * 9)  # 单独一个，或者与前面的1结合在一起
#                 elif s[i - 1] == '2':
#                     dp.append(dp[i]*9 + dp[i - 1] * 6)  # 单独一个，或者与前面的2结合在一起
#                 elif s[i - 1] == '*':
#                     dp.append(dp[i]*9 + dp[i - 1] * (15)) # 后面一个括号里面包含前一个*代表 0，1，2，其它对应的情况数, 应该是15 考虑特殊情况
#                 else:
#                     dp.append(9)
#             print dp
#         return dp[-1]