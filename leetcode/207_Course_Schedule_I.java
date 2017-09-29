// 有向图的遍历问题。
// 给定边的有向图可以用topological sort 来解决。
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // 矩阵记录有向图
        int[] indegree = new int[numCourses]; // 入度的大小
        
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0) 
                indegree[ready] ++;
            matrix[pre][ready] = 1;
        }
        
        // 从入度为0的点开始遍历，看节点个数是否与课程总数相等
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) 
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}


//0928
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) 
            return true;
        // informations
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses]; 
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        // BFS
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        } 
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                count++;
                if (!map.containsKey(cur)) continue;
                for (int j = 0; j < map.get(cur).size(); j++) {
                    inDegree[map.get(cur).get(j)]--;
                    if (inDegree[map.get(cur).get(j)] != 0) continue;
                    queue.offer(map.get(cur).get(j));
                }
            }
        }
        return count == numCourses;
    }
}



// dfs
public boolean canFinish(int numCourses, int[][] prerequisites) {
                //int[][] matrix = new int[numCourses][numCourses];
        List[] adjList = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++){
            if (adjList[prerequisites[i][1]] == null){
                List<Integer> lst = new ArrayList<>();
                adjList[prerequisites[i][1]] = lst;
            }
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // dfs from every course as the begin, the begin course may start from a course with prerequirement.
        for (int i = 0; i < numCourses; i++){
            if ( ! canFinishDFS(adjList, visited, i)) return false;
        }
        return true;
    }
    
    private boolean canFinishDFS(List[] adjList, int[] visited, int i){
        // detected a cycle
        if (visited[i] == -1){
            return false;
        }
        // the path has been checked
        if (visited[i] == 1){
            return true;
        }
        visited[i] = -1;   // attention for flag
        /*
        for (int i = 0; i < adjList[i].size(); i++){
            if (! canFinishDFS( adjList, visited, i)){
                return false;
            }
        }
        */
        List<Integer> lst = adjList[i];
        if (lst != null){
            for (Integer x : lst){
                if (! canFinishDFS( adjList, visited, x)){
                    return false;
                }
            }
        }
        visited[i] = 1;  // attention for flag
        return true;
    }