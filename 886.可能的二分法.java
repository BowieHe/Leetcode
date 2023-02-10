import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] group = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] dislike: dislikes) {
            int i = dislike[0];
            int j = dislike[1];
            graph[i].add(j);
            graph[j].add(i);
        }

        // for(List g: graph) {
            // System.out.println(g.toString());
        // }

        for(int i = 1; i <= n; i++) {
            if(group[i] == 0 && !dfs(graph, i, 1, group)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(List<Integer>[] graph, int level, int color, int[] group) {
        if(group[level] != 0) {
            return group[level] == color;
        }

        group[level] = color;
        // System.out.println(group.toString());
        for(int pos: graph[level]) {
            if(!dfs(graph, pos, -color, group)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

