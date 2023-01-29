import java.util.ArrayList;
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
        
        ArrayList<int[]> triples = new ArrayList<>();
        for(int i = 0; i < tasks.length; i++) {
            triples.add(new int[]{tasks[i][0], tasks[i][1], i});
        }

        triples.sort((a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a ,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // first start time 
        int currentTime = triples.get(0)[0];
        int finishTime = currentTime;
        int index = 0;
        int resIndex = 0;
        int[] res = new int[tasks.length];
        while(index < triples.size() || !pq.isEmpty()) {
            // System.out.print(index);
            // System.out.print("====");
            // System.out.println(resIndex);
            while(index < triples.size() && triples.get(index)[0] == currentTime) {
                int[] task = triples.get(index++);
                pq.offer(new int[]{task[1], task[2]});
            }

            if(finishTime <= currentTime) {
                if(pq.peek() == null) {
                    currentTime = triples.get(index)[0];
                    continue;
                } else {
                    int[] processingTask = pq.poll();
                    res[resIndex++] = processingTask[1];
                    finishTime = currentTime + processingTask[0];  
                }
            } 
        
            if(index < triples.size()) {
                currentTime = Math.min(triples.get(index)[0], finishTime);
            } else {
                currentTime = finishTime;
            }

        }

        return res;
    }
}
// @lc code=end

