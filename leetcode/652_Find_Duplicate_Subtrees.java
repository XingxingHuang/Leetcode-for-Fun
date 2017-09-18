/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Remember to serialize and deserialize tree before compare the tree!!
// 09.15 比较二叉树是否相似时候，可以利用二叉树的序列化简化代码。此题一边序列化一边比较，时间复杂度为O(n)
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";  
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) 
            res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}

// // 2017.07.29 QUESTION 1 time exceed;
// // 我的这个暴力方法中，每次加入新的节点的时候需要遍历整个hashmap来匹配相同的tree，这里其实没有用到hashmap的优势，增加了时间复杂度
// public class Solution {
//     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//         HashMap<TreeNode, Integer> map = new HashMap<>();
//         List<TreeNode>  res = new ArrayList<>();
//         if (root == null) {
//             return res;
//         }
//         map.put(root, 1);
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 // 是否重复，重复则放入results中
//                 boolean flagleft = false;
//                 boolean flagright = false;
//                 for (TreeNode tmp : map.keySet()) {
//                     if (node.left != null && isSame(tmp, node.left)) {
//                         if (map.get(tmp) == 1) {
//                             res.add(node.left);
//                             map.put(tmp, 2);
//                         } else {
//                             map.put(tmp, map.get(tmp) + 1);
//                         }
//                         flagleft = true;
//                         break;
//                     } 
//                 }
//                 // 添加访问过节点
//                 // 访问左节点
//                 if (node.left != null && !flagleft) {
//                     map.put(node.left, 1);
//                 }
//                 if (node.left != null) 
//                     queue.offer(node.left);
//                 // 对有节点进行相同操作
//                 for (TreeNode tmp : map.keySet()) {
//                     // if (node.right != null) 
//                     //     System.out.println(tmp.val + " " + node.right.val);
//                     if (node.right != null && isSame(tmp, node.right)) {
//                         if (map.get(tmp) == 1) {
//                             res.add(node.right);
//                             map.put(tmp, 2);
//                         } else {
//                             map.put(tmp, map.get(tmp) + 1);
//                         }
//                         flagright = true;
//                         break;
//                     } 
//                 }
//                 if (node.right != null && !flagright) {
//                     map.put(node.right, 1);
//                 }
//                 if (node.right != null) 
//                     queue.offer(node.right);
//             }
//         }
//         return res;
//     }
//     private boolean isSame(TreeNode node1, TreeNode node2) {
//         if (node1 == null && node2 == null) {
//             return true;
//         } else if (node1 == null || node2 == null) {
//             return false;
//         }
//         return (node1.val == node2.val) && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
//     }
// }

public class Solution {
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null)  return result;
        convert(root);
        for(String item: map.keySet()) {
            if(map.get(item) >= 2) {
                result.add(deserialize(item));
            }
        }
        return result;
    }
    
    public void convert(TreeNode root) {
        if(root == null)  return;
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        convert(root.left);
        convert(root.right);
    }
    
    public void buildString(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append("N" + ",");
        } else {
            sb.append(root.val + ",");
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }
    
    public TreeNode deserialize(String data) {
        Queue<String> qu = new LinkedList<>();
        qu.addAll(Arrays.asList(data.split(",")));
        return buildTree(qu);
    }
    
    public TreeNode buildTree(Queue<String> qu) {
        if(qu.isEmpty())  return null;
        String cur = qu.remove();
        if(cur.equals("N")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(cur));
            root.left = buildTree(qu);
            root.right = buildTree(qu);
            return root;
        }
    }
}