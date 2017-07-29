# @Author: Xingxing Huang
# @Data: 2017/03/24
# two map method
class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        str_map = {}
        pat_map = {}
        str_array = str.split()
        if len(str_array) != len(pattern):
            return False
        for i, s in enumerate(str_array):
            if str_map.get(s, -1) != pat_map.get(pattern[i], -1):
                return False
            str_map[s] = pat_map[pattern[i]] = i
        return True
        
        
# brute force
class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        str_dict = {}
        str_array = str.split()
        ## WARNING: check the length
        if len(str_array) != len(pattern):
            return False
        for i,s in enumerate(str_array):
            if not str_dict.has_key(pattern[i]):
                # this will increase the complexity
                if s in str_array[0 : i]:
                    return False
                str_dict[pattern[i]] = s
                continue
            if str_dict[pattern[i]] != s:
                return False
        return True

# 其他结果：
# https://leetcode.com/problems/word-pattern/#/solutions

def wordPattern(self, pattern, str):
    s = pattern
    t = str.split()
    return map(s.find, s) == map(t.index, t)
    
def wordPattern(self, pattern, str):
    f = lambda s: map({}.setdefault, s, range(len(s)))
    return f(pattern) == f(str.split())
    
def wordPattern(self, pattern, str):
    s = pattern
    t = str.split()
    return len(set(zip(s, t))) == len(set(s)) == len(set(t)) and len(s) == len(t)