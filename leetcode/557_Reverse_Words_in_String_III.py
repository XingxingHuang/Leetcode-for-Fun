/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: 学习python用法 
 */
 
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return " ".join([c[::-1] for c in s.split()])
        
        
        
# @param {String} s
# @return {String}
def reverse_words(s)
    s.split.map(&:reverse).join(' ')
end