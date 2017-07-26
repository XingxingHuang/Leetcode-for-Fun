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