// 依然是有向图的题目的套路。这里采用了BFS的遍历方法
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 存储有限图，计算节点数据
        int[][] graph = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1]; // notice the order
            int end = prerequisites[i][0];
            if (graph[start][end] == 0)  // avoid duplicates;
                degree[end]++;
            graph[start][end] = 1;
        }

        // BFS
        int[] res = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                res[count++] = i; // 加入结果的上课序列中。
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (graph[course][i] != 0) {
                    if (--degree[i] == 0) {
                        queue.offer(i);
                        res[count++] = i; // 加入结果的上课序列中。
                    }
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}

// 上面的代码可以简化，不必重新存储有向图
// https://discuss.leetcode.com/topic/27940/concise-java-solution-based-on-bfs-with-comments
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;    
    
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
    
        // How many courses don't need prerequisites. 
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--; 
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                } 
            }
        }
    
        return (index == numCourses) ? order : new int[0];
    }
}