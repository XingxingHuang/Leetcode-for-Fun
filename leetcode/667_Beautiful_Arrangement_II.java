// python
class Solution:
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        from functools import reduce 
        return list(reduce(lambda x, y: x + y, [[i, k+2-i] for i in range(1, (k+1) // 2 + 1)])) + ([] if k % 2 != 0 else [k // 2 + 1]) + list(range(k+2, n+1)) 
        
// python
class Solution:
    def constructArray(self, n, k):
        l, r, res = 2, n, [1]
        for _ in range(k - 1):
            if len(res) & 1:
                res.append(r)
                r -= 1
            else:
                res.append(l)
                l += 1
        if len(res) & 1:
            res.extend(range(l, r + 1))
        else:
            res.extend(range(r, l - 1, -1))
        return res
        
        
// java
