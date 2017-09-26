class Solution(object):
    def lengthOfLongestSubstring(self, s):
        result = 0
        left = 0
        last = {}
        for i in range(len(s)):
            if s[i] in last and left <= last[s[i]]:
                left = last[s[i]] + 1
            last[s[i]] = i 
            result = max(result, i - left + 1)
        return result



# both methods are right, with the same speed.

# class Solution(object):
#     def lengthOfLongestSubstring(self, s):
#         """
#         :type s: str
#         :rtype: int
#         """
#         stack = []
#         length = 0
#         length_longest = 0
#         s_longest = ''
#         for i in range(len(s)):
#             if not s[i] in stack:
#                 length += 1
#                 stack.append(s[i])
#                 if length>length_longest:
#                     length_longest = length
#                     s_longest = ''.join(stack)
#             else:
#                 index = stack.index(s[i])
#                 if index+1==len(stack):
#                     stack = [s[i]]
#                     length = 1
#                 else:    
#                     stack = stack[(index+1)::]
#                     stack.append(s[i])
#                     length = len(stack)
#         return(length_longest)      


# class Solution(object):
#     def lengthOfLongestSubstring(self, s):
#         ans = 0
#         # left用于记录合法的左边界位置，last用于记录字符上一次出现的位置
#         left = 0
#         last = {}
#         for i in range(len(s)):
#             # 子串中出现重复字符，变更left至上一次s[i]出现位置之后，使得子串合法
#             if s[i] in last and last[s[i]] >= left:
#                 left = last[s[i]] + 1
#             last[s[i]] = i
#             ans = max(ans, i - left + 1)
#         return ans
                
                
        
        
        
        