import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start
class Solution {

    // bfs
    /*
     * public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     * Queue<List<Integer>> queue = new LinkedList<>();
     * List<List<Integer>> res = new ArrayList<>();
     * 
     * int size = graph.length;
     * 
     * queue.offer(List.of(0));
     * while (!queue.isEmpty()) {
     * int len = queue.size();
     * for (int i = 0; i < len; i++) {
     * List<Integer> q = queue.poll();
     * 
     * int last = q.get(q.size() - 1);
     * if (last == size - 1) {
     * res.add(q);
     * continue;
     * }
     * 
     * int[] nums = graph[last];
     * for (int num : nums) {
     * List<Integer> cur = new ArrayList<>(q);
     * cur.add(num);
     * queue.offer(cur);
     * }
     * }
     * }
     * 
     * return res;
     * }
     */

    // dfs
    List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();

        LinkedList<Integer> list = new LinkedList<>() {
            {
                add(0);
            }
        };
        dfs(graph, 0, list);
        return res;

    }

    void dfs(int[][] graph, int index, LinkedList<Integer> l) {
        if (index == graph.length - 1) {
            res.add(new LinkedList<>(l));
            return;
        }

        int[] nums = graph[index];
        for (int num : nums) {
            l.addLast(num);
            dfs(graph, num, l);
            l.removeLast();
        }
    }

}
// @lc code=end
