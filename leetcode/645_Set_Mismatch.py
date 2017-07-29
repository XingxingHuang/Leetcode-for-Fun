class Solution(object):
    def findErrorNums(self, nums):
        t1 = sum(nums)
        t2 = sum(set(nums))
        l = len(nums)
        return [t1 - t2, l * (l + 1) / 2 - t2]