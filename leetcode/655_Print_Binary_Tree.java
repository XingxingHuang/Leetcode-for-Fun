/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// @Author: Xingxing Huang
// 与solution中的方法一是很相似的。但是我这里根据层数和序号，每次直接计算最终的位置，计算起来有点复杂。
// 如果直接传递进去打印的范围，那么计算和思考起来更加容易
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<List<String>>();
        int m = getheight(root);
        int n = (1 << m) - 1;
        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<String>());
            for (int j = 0; j < n; j++) {
                res.get(i).add("");
            }
        }
        addnode(root, res, m, 0, 0);
        return res;
    }
    private int getheight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getheight(root.left), getheight(root.right)) + 1;
    }
    private void addnode(TreeNode root, List<List<String>> res, int m, int level, int idx) {
        if (root == null) 
            return;
        int x = level;
        int y = (1 << m) - 1; // 初始位置在数组边界处
        int tlevel = level;
        int baseline = (1 << m) - 1;
        while (tlevel >= 0) { // 开始计算下一层的位置，偶数在左边，奇数在右边, 分别扣除或者添加该层的间隔数
            baseline /= 2;
            if (((idx >> tlevel) & 1) == 0) {
                y = y - baseline - 1; // 每层的间隔，总大小 / 该层节点数, 从顶层往下计算
            } else {
                y = y + baseline + 1; 
            }
            tlevel--;
        }     
        res.get(x).set(y, String.valueOf(root.val));
        addnode(root.left, res, m, level + 1, 2 * idx);
        addnode(root.right, res, m, level + 1, 2 * idx + 1);
    }
}

// 简化版本
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<List<String>>();
        int m = getheight(root);
        int n = (1 << m) - 1;
        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<String>());
            for (int j = 0; j < n; j++) 
                res.get(i).add("");
        }
        addnode(root, res, m, 0, 0);
        return res;
    }
    private int getheight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getheight(root.left), getheight(root.right)) + 1;
    }
    private void addnode(TreeNode root, List<List<String>> res, int m, int level, int idx) {
        if (root == null)  return;
        addnode(root.left, res, m, level + 1, 2 * idx);
        addnode(root.right, res, m, level + 1, 2 * idx + 1);
        int x = level;
        int y = (1 << m) - 1; 
        int baseline = (1 << m) - 1;
        while (level >= 0) { 
            baseline /= 2;
            y = ((idx >> level) & 1) == 0 ? (y - baseline - 1) : (y + baseline + 1);
            level--;
        }     
        res.get(x).set(y, String.valueOf(root.val));
    }
}

// Solution: https://leetcode.com/articles/print-binary-tree/
// Method 1, recursive method
// time  O(h * 2^h)
// space O(h * 2^h)
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for(String[] arr:res)
            Arrays.fill(arr,"");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;
        res[i][(l + r) / 2] = "" + root.val;
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
// method 2: 
public class Solution {
    class Params {
        Params(TreeNode n, int ii, int ll, int rr) {
            root = n;
            i = ii;
            l = ll;
            r = rr;
        }
        TreeNode root;
        int i, l, r;
    }
    public List < List < String >> printTree(TreeNode root) {
        int height = getHeight(root);
        System.out.println(height);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr: res)
            Arrays.fill(arr, "");
        List < List < String >> ans = new ArrayList < > ();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr: res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        Queue < Params > queue = new LinkedList();
        queue.add(new Params(root, 0, 0, res[0].length));
        while (!queue.isEmpty()) {
            Params p = queue.remove();
            res[p.i][(p.l + p.r) / 2] = "" + p.root.val;
            if (p.root.left != null)
                queue.add(new Params(p.root.left, p.i + 1, p.l, (p.l + p.r) / 2));
            if (p.root.right != null)
                queue.add(new Params(p.root.right, p.i + 1, (p.l + p.r + 1) / 2, p.r));
        }
    }
    public int getHeight(TreeNode root) {
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            Queue < TreeNode > temp = new LinkedList();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
            }
            queue = temp;
        }
        return height;
    }
}