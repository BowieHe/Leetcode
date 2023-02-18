import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1514 lang=java
 *
 * [1514] 概率最大的路径
 */

// @lc code=start
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            graph[edge[0]].add(new double[]{(double)edge[1], prob});
            graph[edge[1]].add(new double[]{(double)edge[0], prob});

        }

        return dijkstra(start, end, graph);

    }

    class State {
        int num;
        double distanceFromStart;

        public State(int num, double distanceFromStart) {
            this.num = num;
            this.distanceFromStart = distanceFromStart;
        }
    }

    public double dijkstra(int start, int end, List<double[]>[] graph) {
        int v = graph.length;
        double[] distTo = new double[v];
       
        Arrays.fill(distTo, -1);
        distTo[start] = 1.0;
        State sta = new State(start, 1.0);
        Queue<State> pq = new PriorityQueue<State>((a, b) -> {
            return Double.compare(b.distanceFromStart, a.distanceFromStart);
        });
        
        pq.offer(sta);
        while(!pq.isEmpty()) {
            State curState = pq.poll();
            
            if(curState.num == end) {
                return curState.distanceFromStart;
            }

            if(curState.distanceFromStart < distTo[curState.num]) {
                continue;
            }

            List<double[]> gra = graph[curState.num];
            for(double[] edge: gra) {
                int nextNum = (int)edge[0];
                double prob = edge[1];
                double probToNext = prob * distTo[curState.num];
                System.out.println("get prob" + probToNext + " with node " + nextNum);
                if(probToNext > distTo[nextNum]) {
                    State next = new State(nextNum, probToNext);
                    distTo[nextNum] = probToNext;
                    pq.offer(next);
                }
            }

        }

        return 0.0;
    }
}
// @lc code=end

