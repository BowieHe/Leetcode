import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // for each pq, it contains [product(current value), prime, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for(int i = 0; i < primes.length; i++) {
            pq.offer(new int[]{1, primes[i], 1});
        }

        int[] ugly = new int[n + 1];
        // System.out.println(ugly[0]);
        int pos = 1;
        while(pos <= n) {
            int[] current = pq.poll();
            int product = current[0];
            int prime = current[1];
            int index = current[2];
            if(product != ugly[pos - 1]){
                ugly[pos] = product;
                pos++;
            }
            int[] next = new int[]{ugly[index] * prime, prime, index + 1};
            pq.offer(next);
        }
        return ugly[n];
    }
}
// @lc code=end

