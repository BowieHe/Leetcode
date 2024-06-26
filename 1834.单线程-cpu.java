import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1834 lang=java
 *
 * [1834] 单线程 CPU
 */

// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        // startTime, consume time, index
        int[][] tup = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            tup[i] = new int[] { tasks[i][0], tasks[i][1], i };
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        Arrays.sort(tup, (a, b) -> a[0] - b[0]);

        // for(int i = 0; i < tasks.length; i++) {
        // pq.offer(new int[]{tasks[i][0], tasks[i][0], i});

        // }

        // while(!pq.isEmpty()) {
        // System.out.println(pq.poll()[2]);
        // }

        int[] res = new int[tup.length];
        int time = 0;
        int index = 0, order = 0;

        // System.out.println(tup[0][0]);
        // pq.offer(new int[] { tup[0][0], tup[0][1], 0 });

        while (!pq.isEmpty() || time < tup[tup.length - 1][0]) {
            // System.out.println("get Time: " + time);
            if (!pq.isEmpty()) {
                int[] t = pq.poll();
                time = Math.max(time, t[0]);
                time += t[1];

                // System.out.println("get time:" + time + " and index:" + t[2]);
                res[order++] = t[2];
            } else if (index < tup.length && tup[index][0] > time) {
                time = tup[index][0];
            }

            while (index < tup.length && tup[index][0] <= time) {
                pq.offer(new int[] { tup[index][0], tup[index][1], tup[index][2] });
                index++;
            }
        }

        return res;
    }
}
// @lc code=end
