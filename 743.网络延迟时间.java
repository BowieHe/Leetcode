import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] time: times) {
            graph[time[0]].add(new int[]{time[1], time[2]});

        }

        int[] res = dijkstra(graph, n, k);

        int maxVal = -1;
        for(int a: res) {
            if(a == Integer.MAX_VALUE) {
                return -1;
            }
            maxVal = Math.max(a, maxVal);
        }
        return maxVal;
    }

    class State {
        int num;
        int distance;

        public State(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    public int[] dijkstra(List<int[]>[] graph, int n, int k) {
        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;
        distances[0] = -1;

        State start = new State(k, 0);
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distance - b.distance;
        });
        pq.offer(start);
        while(!pq.isEmpty()) {
            State currState = pq.poll();

            int num = currState.num;
            int distance = currState.distance;
            System.out.println("current node " + num + " distance: " + distance);

            if(distance > distances[num]) {
                continue;
            }
            for(int[] gra: graph[num]) {
                int curDis = distances[num] + gra[1];

                if(curDis < distances[gra[0]]) {
                    pq.offer(new State(gra[0], curDis));
                    distances[gra[0]] = curDis;
                }
            }
        }
        return distances;
    }
}
// @lc code=end

