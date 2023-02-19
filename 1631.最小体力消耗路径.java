import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1631 lang=java
 *
 * [1631] 最小体力消耗路径
 */

// @lc code=start
class Solution {
    int m, n;
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distance - b.distance;
        });

        int[][] effort = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        pq.offer(new State(0, 0, 0));
        while(!pq.isEmpty()) {
            State curNode = pq.poll();
            int x = curNode.x;
            int y = curNode.y;
            System.out.println("curNum " + pq.size());
            System.out.println("process " + x + " and y " + y + " and " + curNode.distance);
            if(curNode.x == m - 1 && curNode.y == n - 1) {
                return curNode.distance;
            }

            if(effort[x][y] < curNode.distance) {
                continue;
            }

            for(int[] node: nextNodes(x, y)) {
                int nodeX = node[0];
                int nodeY = node[1];
                int e = Math.max(effort[x][y], Math.abs(heights[x][y] - heights[nodeX][nodeY]));
                // System.out.println("process x" + x + "y" + y + "e" + e + "nodex" + nodeX + "nodeY" + nodeY);
                if(e < effort[nodeX][nodeY]) {
                    pq.offer(new State(nodeX, nodeY, e));
                    effort[nodeX][nodeY] = e;
                }
            }
        }
        return -1;

    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    List<int[]> nextNodes(int x, int y) {
        List<int[]> nodes = new ArrayList<>();
        for(int[] dir: dirs) {
            int row = x + dir[0];
            int column = y + dir[1];
            if(row < 0 || row > m - 1 || column < 0 || column > n - 1) {
                continue;
            }
            nodes.add(new int[]{row, column});
        }
        return nodes;
    }
    class State {
        int x, y;
        int distance;

        State(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
// @lc code=end

