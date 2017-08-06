class Solution(object):

    def cheapestJump(self, A, B):
        """
        :type A: List[int]
        :type B: int
        :rtype: List[int]
        """
        if not A or A[0] == -1:
            return []
        dp = [[float('inf')] for i in A]
        dp[0] = [A[0], 1]
        N = len(A)
        for i in range(N):
            if A[i] == -1:
                continue
            for j in range(i + 1, min(N, i + B + 1)):
                if A[j] == -1:
                    continue
                if dp[i][0] + A[j] < dp[j][0]:
                    dp[j] = [dp[i][0] + A[j]] + dp[i][1:] + [j + 1]
                if dp[i][0] + A[j] == dp[j][0]:
                    path = dp[i][1:] + [j + 1]
                    if path < dp[j][1:]:
                        dp[j] = [dp[i][0] + A[j]] + dp[i][1:] + [j + 1]
        # return dp
        return dp[-1][1:]