// @Author: Xingxing Huang
// @Time:
// @Date: 2017/03/26
// (1) Burtforce DFS解法: 如果直接从前往后遍历，用栈记录可以分割的节点，那么会产生很多无法正确分词无效路径。
// (2) 参考Leetcode 139. Word Break的解法: https://leetcode.com/problems/word-break/, 可以采用更加优化方法
//     可以用HashMap记录每个可分位置的不同分割方法。最后仅需要将HashMap的length - 1位置的记录提取出来组成字符串数组输出。
// 下面表示了可能的分割方法，HashMap会记录每个分割点可能的分割方法。
//   c a t s a n d d o g
//   0 1 2 3 4 5 6 7 8 9
//       * *     *     *
//      map[2位置] = [0,3]
//      map[3位置] = [0,4]
//      map[6位置] = [0,3,7], [0,4,7]
//      map[9位置] = [0,3,7,10], [0,4,7,10]
// (3) 可以发现这样上面存储有很多的冗余，实际上可以看成树形结构，因此我们可以结合(1)的DFS思想进一步优化。
//    用一个HashMap 记录到达最终分割点的路径，处理一条结果后回溯到上一个分割点。
//            0
//           /  \
//          3    4
//           \  /
//            7    
//            |    
//            10   
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> res = new ArrayList<String>();
        if (wordDict.size() == 0) {
            return res;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        boolean[] f = new boolean[s.length() + 1];  // 长度+1
        f[0] = true;
        ArrayList list = new  ArrayList<Integer>();
        list.add(0);
        map.put(0, list);
        // create map to save the paths
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    if (map.containsKey(i)) {
                        map.get(i).add(j);
                    } else {
                        map.put(i, new ArrayList<Integer>());
                        map.get(i).add(j);
                    }
                }
            }
        }
        // dfs search for paths.
        if (f[s.length()]) {
            dfs(s, map, res, s.length(), "");
        }
        return res;
    }
    
    public void dfs(String s, HashMap<Integer, ArrayList<Integer>> map, ArrayList<String> res, int end, String words) {
        ArrayList<Integer> list = map.get(end);
        for (int i: list) {
            if (i == end) {
                res.add(words);
                return;
            }
            String words2 = s.substring(i, end) + (words.equals("") ? "": " ") + words;
            dfs(s, map, res, i, words2);
        }
    }
}