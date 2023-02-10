import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == 0 && !dfs(graph, 1, i, visited)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int[][] graph, int color, int currentVal, int[] visited) {
        if(visited[currentVal] != 0) {
            return visited[currentVal] == color;
        }

        visited[currentVal] = color;
        int[] joints = graph[currentVal];
        for(int joint: joints) {
            if(!dfs(graph, -color, joint, visited)) {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

