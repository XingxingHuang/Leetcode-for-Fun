# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def dfs(self, r, dep, no):
        if r is None:
            return
        if dep not in self.d:
            self.d[dep] = []
        self.d[dep].append(no)
        self.dfs(r.left, dep + 1, no * 2)
        self.dfs(r.right, dep + 1, no * 2 + 1)
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.d = dict()
        self.dfs(root, 0, 1)
        ans = 0
        for x in self.d:
            ans = max(ans, self.d[x][-1] - self.d[x][0] + 1)
        return ans