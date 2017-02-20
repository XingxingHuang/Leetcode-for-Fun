class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        s = [0] * (len(num1) + len(num2))
        for i in range(len(num1) - 1, -1, -1):
            for j in range(len(num2) - 1, -1, -1):
                num = s[i + j + 1] + int(num1[i]) * int(num2[j])
                s[i + j + 1] = num % 10
                # 注意这个地方的值可以大于10，但是会在下一轮中变成小于10
                s[i + j] += num / 10
                #print s
        # add to string
        out = ''
        for temp in s:
            # 注意第一个元素是空的情况
            if out != '' or temp != 0:  
                out += str(temp)
        return out