# 九章的python代码，这里体现了python中栈操作的便利性。
# http://www.jiuzhang.com/solutions/binary-tree-zigzag-level-order-traversal/
from lintcode import TreeNode
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""


class Solution:
    """
    @param root: The root of binary tree.
    @return: A list of list of integer include 
             the zig zag level order traversal of its nodes' values
    """
    def preorder(self, root, level, res):
        if root:
            if len(res) < level+1: res.append([])
            if level % 2 == 0: 
                res[level].append(root.val)
            else: 
                res[level].insert(0, root.val)
            self.preorder(root.left, level+1, res)
            self.preorder(root.right, level+1, res)
    def zigzagLevelOrder(self, root):
        self.results = []
        self.preorder(root, 0, self.results)
        return self.results