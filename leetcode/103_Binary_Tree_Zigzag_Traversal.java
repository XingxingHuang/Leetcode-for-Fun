/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 0928 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        tranverse(root, 1, res);
        return res;
    }
    public void tranverse(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (res.size() < level) res.add(new ArrayList<Integer>());
        if (level % 2 == 1) 
            res.get(level-1).add(root.val);
        else 
            res.get(level-1).add(0, root.val);
        tranverse(root.left, level + 1, res);
        tranverse(root.right, level + 1, res);
    }
}

// non recursive
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }
}


// // offer = offerLast
// // poll = pollFirst
// // WARNING, bfs cannot be used to solve this problem
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (root == null) 
//             return res;
//         Deque<TreeNode> dq = new LinkedList<>();
//         dq.offer(root);
//         boolean order = true;
//         while (!dq.isEmpty()) {
//             int size = dq.size();
//             res.add(new ArrayList<Integer>());
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = order ? dq.poll() : dq.pollLast();
//                 res.get(res.size() - 1).add(cur.val);
//                 if (cur.left != null) 
//                     if (order)  
//                         dq.offerFirst(cur.left);
//                     else 
//                         dq.offer(cur.left);
//                 if (cur.right != null)
//                     if (order)
//                         dq.offerFirst(cur.right);
//                     else 
//                         dq.offer(cur.right);
//             }
//             order = !order;
//         }
//         return res;
//     }
// }