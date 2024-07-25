import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // ArrayList<Integer>[] graph = new ArrayList[nunumCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] req : prerequisites) {
            graph[req[0]].add(req[1]);
        }

        // 0 nerver been to, 1 searching, 2 finished
        int[] route = new int[numCourses];
        Arrays.fill(route, 0);
        boolean valid = true;
        for (int i = 0; i < numCourses && valid; i++) {
            valid = dfs(graph, i, route);
        }

        return valid;
    }

    boolean dfs(List<Integer>[] graph, int index, int[] route) {
        if (route[index] == 2) {
            return true;
        } else if (route[index] == 1) {
            return false;
        }

        route[index] = 1;
        List<Integer> nums = graph[index];
        for (int num : nums) {
            if (!dfs(graph, num, route)) {
                return false;
            }

        }

        route[index] = 2;

        return true;

    }
}
// @lc code=end
