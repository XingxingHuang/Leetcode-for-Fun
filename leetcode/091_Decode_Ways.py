class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s: 
            return 0
        dp = [1] + [0] * len(s)
        # 如果i 不为0, 那么至少可以是dp[i]次
        # 考虑i 和 i-1 位，如果i>0 并且 i-1 和第 i 位可以组合成10到26之间的数字，那么至少可以dp[i-1]次
        for i in range(len(s)):
            dp[i + 1] = dp[i] * (int(s[i]) > 0) + dp[i - 1] * (i and 10 <= int(s[i - 1: i + 1]) <= 26)
        return dp[-1]
        
        
# # 此程序超时        
# class Solution(object):
#     def numDecodings(self, s):
#         """
#         :type s: str
#         :rtype: int
#         """
#         if len(s) == 0: return 0
#         return self.getnum(s)
        
#     def getnum(self, s):
#         # 如果长度为1 或者为2
#         if len(s) == 1:
#             return 1 if self.test(s) else 0
#         if len(s) == 2:
#             if self.test(s[0]) and self.test(s[1]):
#                 return 2 if self.test(s) else 1
#             return 1 if self.test(s) else 0
#         # 长度大于2 因为可能包含0，考虑四种情况
#         if not self.test(s[0]) and self.test(s[0:2]):
#             return self.getnum(s[2:])
#         elif self.test(s[0]) and not self.test(s[0:2]):
#             return self.getnum(s[1:])
#         elif self.test(s[0]) and self.test(s[0:2]):
#             return self.getnum(s[1:]) + self.getnum(s[2:])
#         else:
#             return 0 

            
#     def test(self, s):
#         # 测试是否能够转化成A-Z
#         if int(s[0]) == 0:
#             return False
#         if int(s) >= 1 and int(s) <= 26:
#             return True
        
        