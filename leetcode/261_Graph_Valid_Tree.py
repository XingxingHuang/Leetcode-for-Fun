# http://www.jiuzhang.com/solutions/graph-valid-tree/
class Solution:
    # @param {int} n an integer
    # @param {int[][]} edges a list of undirected edges
    # @return {boolean} true if it's a valid tree, or false
    def validTree(self, n, edges):
        # Write your code here
        root = [i for i in range(n)]
        for i in edges:
            root1 = self.find(root, i[0])
            root2 = self.find(root, i[1])
            if root1 == root2:
                return False
            else:
                root[root1] = root2
        return len(edges) == n - 1
        
    def find(self, root, e):
        if root[e] == e:
            return e
        else:
            root[e] = self.find(root, root[e])
            return root[e]