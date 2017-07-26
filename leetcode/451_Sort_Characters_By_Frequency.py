# @Author 黄xing 利用dictionary类型和bucket方法完成
class Solution(object):
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        # save the number counts into a dictionary
        scount = {}
        maxValue = 0
        for char in s:
            scount[char] = scount.get(char, 0) + 1
            if scount[char] > maxValue:
                maxValue = scount[char] 

        # use a bucket to save the order    
        bucket = []
        for i in range(maxValue + 1):
            bucket.append([])
        for key, value in scount.iteritems():
            bucket[value].append(key)
        
        # join the string 
        out = ""
        for i in range(len(bucket) - 1, 0, -1):
            if bucket[i] == []:
                continue
            for char in bucket[i]:
                out += char * i
        return out