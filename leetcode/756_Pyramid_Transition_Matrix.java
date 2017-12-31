// 12.30 典型DP题，需要增加敏感度
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int n = bottom.length();
        int[][] to = new int[7][7];
        for(String a : allowed){
            int x = a.charAt(0)-'A';
            int y = a.charAt(1)-'A';
            int z = a.charAt(2)-'A';
            to[x][y] |= 1<<z;
        }
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
            dp[i] = 1<<bottom.charAt(i)-'A';
        }
        for(int i = n-1;i >= 1;i--){
            int[] ndp = new int[i];
            for(int j = 0;j < i;j++){
                int l = dp[j], r = dp[j+1];
                for(int k = 0;k < 7;k++){
                    for(int u = 0;u < 7;u++){
                        if(l<<~k<0 && r<<~u<0){
                            ndp[j] |= to[k][u];
                        }
                    }
                }
            }
            dp = ndp;
        }
        return dp[0] != 0;
    }
}   



# contest 时候的代码
# graph? DFS? 超时， 采用的记忆化搜索的思想。但是超时
class Solution:
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        allowed_map = {}
        for a in allowed:
            if not a[0:2] in allowed_map:
                allowed_map[a[0:2]] = []
            allowed_map[a[0:2]].append(a[2])
        self.visited = set()
        return self.check(bottom, allowed_map, "", 0)
    
    def check(self, bottom, allowed, s, idx):
        #终止条件
        if len(bottom) == 1:
            return True
        #进入下一层
        if idx == len(bottom) - 1:
            if s in self.visited:
                return False
            self.visited.add(s)
            return self.check(s, allowed, "", 0)
        # # 直接退出
        # if not bottom[idx: idx + 2] in allowed:
        #     return False
        # 与判断是否可行
        for i in range(len(bottom) - 1):
            if not bottom[i: i + 2] in allowed:
                # self.visited.add(bottom)
                return False
        # DFS 每一个字母
        for a in allowed[bottom[idx: idx + 2]]:
            if self.check(bottom, allowed, s + a, idx+1):
                return True
        return False
            
  
// 未完成，代码错误，没有考虑从后往前的情形   
class Solution:
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """       
        n = len(bottom)
        dp = [[[False for i in range(7)] for j in range(n)] for k in range(n)]
        # print(np.shape(dp))
        for i in range(n):
            for k in range(7):
                dp[i][i][k] = True
            
        allowed_map = {}
        for a in allowed:
            if not a[0:2] in allowed_map:
                allowed_map[a[0:2]] = []
            allowed_map[a[0:2]].append(a[2])

        # for j in range(1, n):
        #     for i in range(n):
        #         if (i + j >= n): continue
        #         if j == 1:
        #             if bottom[i: (i + j + 1)] in allowed_map:
        #                 for a in allowed_map[bottom[i: (i + j + 1)]]:
        #                     dp[i][j][ord(a) - ord('A')] = True
        #         else:
        #             for k in range(7):
        #                 if dp[i][i + j - 1][k] == True:
        #                     # print(i, i + j - 1, k)
        #                     s = chr(ord('A') + k) + bottom[i + j]
        #                     if s in allowed_map:
        #                         for a in allowed_map[s]:
        #                             dp[i][i + j][ord(a) - ord('A')] = True  
        for i in range(n):
            for j in range(i + 1, n):
                for m in range(j - i):
                    if dp[i][i + m] and dp[i + m + 1][j]:
                        
                    
                                    
        for k in range(7):
            if dp[0][n - 1][k]: return True
        # print(dp)
        return False
                    
                