import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start
class Solution {
    int len;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        len = graph.length;
        res = new ArrayList<>();
        if(len == 0) {
            return new ArrayList<>();
        }
        LinkedList paths = new LinkedList();
        paths.addFirst(0);
        findPath(graph, 0, len - 1, paths);
        return res;
    }

    void findPath(int[][] graph, int start, int end, LinkedList<Integer> paths) {

        if(start == end) {
            
            res.add(new LinkedList<>(paths));
            paths.removeLast();
            return;
        }

        int[] current = graph[start];
        for(int pos: current) {
            paths.addLast(pos);
            System.out.println(String.format("get pos %d, %s", pos, paths.toString()));
            findPath(graph, pos, end, paths);
        }
        paths.removeLast();
    }
}
// @lc code=end

