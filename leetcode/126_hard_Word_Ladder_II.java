class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();   //结果路径
        // List<List<String>> res = new ArrayList<List<String>>();         
        HashSet<String> dict = new HashSet<>(wordList);     // 访问过得单词
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>(); // 临近的单词
        HashMap<String, Integer> distance = new HashMap<>();    //单词距离
        ArrayList<String> solution = new ArrayList<String>();   //单个路径结果
        //
        dict.add(beginWord);
        // 得到图结构
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        // 得到路径
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);
        return res;
    }
    
    private void bfs(String start, String end,
                     Set<String> dict, 
                     HashMap<String, ArrayList<String>> nodeNeighbors,
                     HashMap<String, Integer> distance) {
        for (String str: dict) 
            nodeNeighbors.put(str, new ArrayList<>());
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor)) 
                            foundEnd = true;
                        else 
                            queue.offer(neighbor);
                    }
                }
            }
            if (foundEnd) break;
        }
    }
    // Find all next level nodes.    
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
      ArrayList<String> res = new ArrayList<String>();
      char chs[] = node.toCharArray();

      for (char ch ='a'; ch <= 'z'; ch++) {
          for (int i = 0; i < chs.length; i++) {
              if (chs[i] == ch) continue;
              char old_ch = chs[i];
              chs[i] = ch;
              if (dict.contains(String.valueOf(chs))) {
                  res.add(String.valueOf(chs));
              }
              chs[i] = old_ch;
          }

      }
      return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
           res.add(new ArrayList<String>(solution));
        } else {
           for (String next : nodeNeighbors.get(cur)) {            
                if (distance.get(next) == distance.get(cur) + 1) {
                     dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }           
       solution.remove(solution.size() - 1);
    }
}