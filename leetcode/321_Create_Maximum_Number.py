# @Author: Xingxing Huang
# @Date: 2017.04.02
# @Time: (m*n)*k
# 思路： 暴力解法，每次从前面找到最大的数加入到结果中。当剩余数组长度之和为给定长度，返回两个数组的merge。但是无法解决两个数组中前面几个数都包含最大得数时，选择哪个数组中的数的问题。
class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        len1 = len(nums1)
        len2 = len(nums2)
        if len1 == 0:
            return self.select(nums2, k)
        if len2 == 0:
            return self.select(nums1, k)
        maxValue = -1
        index1 = -1
        index2 = -1
        for i, n1 in enumerate(nums1):
            for j,n2 in enumerate(nums2):
                if len1 + len2 - i - j < k:
                    continue
                if n1 > maxValue:
                    index1 = i
                    index2 = -1
                    maxValue = n1
                if n2 > maxValue:
                    index1 = -1
                    index2 = j
                    maxValue = n2
        if k == 1:
            return [maxValue]
        if index1 == -1:
            res = self.maxNumber(nums1, nums2[(index2 + 1):], k - 1) 
        else:
            res = self.maxNumber(nums1[(index1 + 1):], nums2, k - 1)
        return [maxValue] + res
        
    def select(self, nums, k):
        if len(nums) == k:
            return nums
        maxValue = nums[0]
        for i, n in enumerate(nums):
            if len(nums) - i < k:
                return [maxValue] + self.select(nums[i:], k - 1)
            if n > maxValue:
                maxValue = n
        return [maxValue]
            