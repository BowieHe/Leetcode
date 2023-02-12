import java.beans.Visibility;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    boolean[] visited;
    boolean[] paths;
    boolean hasCircle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        paths = new boolean[numCourses];
        hasCircle = false;

        for(int i = 0; i < numCourses; i++) {
            traverse(i, graph);
        }
        return !hasCircle;
    }

    void traverse(int level, List<Integer>[] graph) {
        if(paths[level]) {
            hasCircle = true;
        }

        if(visited[level] || hasCircle) {
            return ;
        }
        //前序遍历
        paths[level] = true;
        visited[level] = true;
        for(int n: graph[level]) {
            traverse(n, graph);
        }
        //后序遍历
        paths[level] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList();
        }

        for(int[] requists: prerequisites) {
            int from = requists[0];
            int to = requists[1];
            graph[from].add(to);
        }
        return graph;
    }
}
// @lc code=end

