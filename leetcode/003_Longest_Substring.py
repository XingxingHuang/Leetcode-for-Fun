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