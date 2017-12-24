# 12.23
# TLE
class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        # 记录deadends
        dead = set()
        for d in deadends:
            dead.add(int(d))
        #
        dp = [[[[10000 for col in range(10)] for row in range(10)] for x in range(10)] for y in range(10)]
        dp[0][0][0][0] = 0
        # 
        for i in range(10) + range(9,0,-1):
            for j in range(10) + range(9,0,-1):
                for m in range(10) + range(9,0,-1):
                    for n in range(10) + range(9,0,-1):
                        if 1000*i + 100*j + 10*m + n in dead:
                            dp[i][j][m][n] = -1
                        else:
                            #
                            if not 1000*i + 100*j + 10*m + (10 + n - 1)%10 in dead: #左边不在dead中
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[i][j][m][(10 + n - 1)%10] + 1)
                            if not 1000*i + 100*j + 10*m + (n + 1)%10 in dead: #右边不在dead中
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[i][j][m][(n + 1)%10] + 1)
                            #
                            if not 1000*i + 100*j + 10*((10 + m - 1)%10) + n in dead: 
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[i][j][(10 + m - 1)%10][n] + 1)
                            if not 1000*i + 100*j + 10*((m + 1)%10) + n in dead: 
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[i][j][(m + 1)%10][n] + 1)
                            #
                            if not 1000*i + 100*((10 + j - 1)%10) + 10*m + n in dead: 
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[i][(10 + j - 1)%10][m][n] + 1)
                            if not 1000*i + 100*((j + 1)%10) + 10*m + n in dead: 
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[i][(j + 1)%10][m][n] + 1)
                            #
                            if not 1000*((10 + i - 1)%10) + 100*j + 10*m + n in dead: 
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[(10 + i - 1)%10][j][m][n] + 1)
                            if not 1000*((i + 1)%10) + 100*j + 10*m + n in dead: 
                                dp[i][j][m][n] = min(dp[i][j][m][n], dp[(i + 1)%10][j][m][n] + 1)
                            if str(i)+str(j)+str(m)+str(n) == target:
                                if (dp[i][j][m][n] == -1 or dp[i][j][m][n] > 9999):
                                    return -1
                                return dp[i][j][m][n]

    
class Solution:
    def openLock(self, deadends, target):
        # BFS for the target
        deadends = set(deadends)
        visited = set('0000')
        nLevel = 0
        if '0000' in deadends or target in deadends: return -1
        #
        level = ['0000']
        while level:
            nLevel += 1
            newLevel = []
            for curr in level:  #每一个元素
                for i in range(4): #每一个位置
                    for j in [(int(curr[i]) - 1) % 10, (int(curr[i]) + 1) % 10]: #该位置+1 -1
                        candidate = curr[:i] + str(j) + curr[i + 1:]
                        if candidate not in visited and candidate not in deadends:
                            newLevel.append(candidate)
                            visited.add(candidate)
                        if candidate == target:
                            return nLevel
            level = newLevel
        return -1