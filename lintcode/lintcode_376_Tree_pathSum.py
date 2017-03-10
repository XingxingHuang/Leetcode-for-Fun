"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    # @param {TreeNode} root the root of binary tree
    # @param {int} target an integer
    # @return {int[][]} all valid paths
    def binaryTreePathSum(self, root, target):
        # Write your code here
        res = []
        temp = []
        if (root is None):
            return res
        res, temp = self.helper(root, target, res, temp)
        return res

    def helper(self, root, target, res, temp):
        if (root is None):
            return res, temp
        temp.append(root.val)
        if (root.val == target
                and root.left is None
                and root.right is None):
            res.append(temp[:])
        target -= root.val
        res, temp = self.helper(root.left, target, res, temp)
        res, temp = self.helper(root.right, target, res, temp)
        return res, temp[0 : -1]