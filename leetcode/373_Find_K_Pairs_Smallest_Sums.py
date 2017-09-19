# @Author 黄xing
# 时间复杂度O  空间复杂度O(m*n)
# 用一个数组signArray记录两个数组的i,j元素是否已经被访问过
# 用一个字典sign记录下一个可能的和，key为可能的和，value为可能组合[i,j]
# 每次访问后修改signArray的元素[i, j]，并且将sign中加入[i+1, j], [i, j+1]。
# 这个解法是比较暴力的解法，仅供玩耍。请参考每日一题的总结
# https://mp.weixin.qq.com/s?__biz=MzAwMDk1MTUyNw==&mid=2247484396&idx=1&sn=7695c3ab485d4c7f4d6550abb6a6bf1d&chksm=9ae05664ad97df728981365be049a404adb29d20d06ff9c2184a6281a83bfc27434396d8db9d&mpshare=1&scene=1&srcid=0304uPZUD4ZVi5EYs2xHql2l&key=ffb143053294525da11c7407e72b19138855002aa9b4ce1effd4f6d19f3de3af8bbfe15d22699e69f1087f6e0e0fceec864f8c0528a595d2bbb5902893d145300114f06bdfd8db2f79d26c07aabc3164&ascene=0&uin=NzIzOTQyODAx&devicetype=iMac+MacBookPro11%2C1+OSX+OSX+10.9.5+build(13F1911)&version=11020201&pass_ticket=TKvDM5DJORTN5tScGoHqUlIXdOJ0VsfcxNgYgHUl6Fikeub6Aj4jSRE2fml%2BKQ0w
# http://www.jiuzhang.com/solutions/kth-smallest-sum-in-two-sorted-arrays/
# http://www.lintcode.com/zh-cn/problem/kth-smallest-sum-in-two-sorted-arrays/
class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        # 记录(i,j)是否访问过
        signArray = [[0 for col in range(len(nums2))] for row in range(len(nums1))]
        # key 为 最小的和
        sign = {}
        i = 0 
        j = 0 
        out = []
        while (len(out) < len(nums1) * len(nums2) and len(out) < k):
            # 每次取出最小的 pair. 初始的时候pair 为（0, 0）
            if sign != {}:
                key = min(sign.keys())
                i = sign[key][-1][0]
                j = sign[key][-1][1]
                if len(sign[key]) == 1:
                    sign.pop(key)
                else:
                    sign[key].pop()
                if signArray[i][j] == 1:
                    continue
            # 修改访问记录，加入数据到结果中。
            signArray[i][j] = 1
            out.append([nums1[i], nums2[j]])
            # 将(i + 1, j) 和 (i, j + 1)放入存储中。
            if i + 1 < len(nums1) and signArray[i + 1][j] == 0:
                if not nums1[i + 1] + nums2[j] in sign:
                    sign[nums1[i + 1] + nums2[j]] = []
                sign[nums1[i + 1] + nums2[j]].append([i + 1, j])
            if j + 1 < len(nums2) and signArray[i][j + 1] == 0:
                if not nums1[i] + nums2[j + 1] in sign:
                    sign[nums1[i] + nums2[j + 1]] = []
                sign[nums1[i] + nums2[j + 1]].append([i, j + 1])
        return out
        
        
         
        # # if len(nums1) * len(nums2) < k:
        # #     return []
        # sign = {}
        # i = 0 
        # j = 0 
        # out = []
        # while (len(out) < k):
        #     print sign
        #     if sign != {}:
        #         key = min(sign.keys())
        #         i = sign[key][-1][0]
        #         j = sign[key][-1][1]
        #         if len(sign[key]) == 1:
        #             sign.pop(key)
        #         else:
        #             sign[key].pop()
        #     out.append([nums1[i], nums2[j]])
        #     if i + 1 < len(nums1):
        #         if not nums1[i + 1] + nums2[j] in sign:
        #             sign[nums1[i + 1] + nums2[j]] = []
        #         sign[nums1[i + 1] + nums2[j]].append([i + 1, j])
        #     if j + 1 < len(nums2):
        #         if not nums1[i] + nums2[j + 1] in sign:
        #             sign[nums1[i] + nums2[j + 1]] = []
        #         sign[nums1[i] + nums2[j + 1]].append([i, j + 1])
        # return out
                    
        # if len(nums1) * len(nums2) < k:
        #     return []
        # out = []
        # stack1 = [0, 0]
        # stack2 = [0, 0]
        # while len(out) < k:
        #     print '1', stack1
        #     print '2', stack2
        #     sum1 = nums1[stack1[0]] + nums2[stack1[1]]
        #     if stack1[0] == stack2[0] and stack1[1] == stack2[1]: 
        #         stack2[0] = stack2[0] + 1
        #         if stack2[0] == len(nums1):
        #             stack2 = [stack1[0], stack1[1] + 1]
        #     sum2 = nums1[stack2[0]] + nums2[stack2[1]]
            
        #     if sum1 < sum2:
        #         out.append([nums1[stack1[0]], nums2[stack1[1]]])
        #         stack1[1] = stack1[1] + 1
        #         if stack1[1] == len(nums2):
        #             if stack2[1] + 1 < len(nums2):
        #                 stack1 = [stack2[0], stack2[1] + 1]
        #             else:
        #                 stack1 = [stack1[0] + 1, len(nums2) - 1]
        #     else:
        #         out.append([nums1[stack2[0]], nums2[stack2[1]]])

        #         stack2[0] = stack2[0] + 1
        #         if stack2[0] == len(nums1):
        #             if stack1[0] + 1 < len(nums1):
        #                 stack2 = [stack1[0] + 1, stack1[1]]
        #             else:
        #                 stack2 = [len(nums1) - 1, stack2[1] + 1]
        #     print len(out), ': ', out
        # return out

            
            # if sum1 > sum2:
            #     temp = [stack1[0], stack1[1]]
            #     stack1 = stack2
            #     stack2 = temp