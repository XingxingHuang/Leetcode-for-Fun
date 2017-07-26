# 超时，平方复杂度
# @Author 黄xing
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        out = [];
        for i in range(n):
            for j in range(n - 1):
                index = (i + j + 1) % n;
                if nums[index] > nums[i]:
                    out.append(nums[index])
                    break
            if len(out) < i + 1:
                out.append(-1)
        return out
                    
                