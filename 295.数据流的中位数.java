import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;

    MedianFinder() {
        this.small = new PriorityQueue<>((a, b) -> b - a);
        this.big = new PriorityQueue<>();
    }

    public void addNum(int num) {
        this.small.offer(num);

        while (this.small.size() - this.big.size() > 1) {
            this.big.offer(this.small.poll());
        }

        while (this.small.size() > 0 &&
                this.big.size() > 0 &&
                this.small.peek() > this.big.peek()) {
            int s = this.small.poll(), b = this.big.poll();
            this.small.offer(b);
            this.big.offer(s);
        }

    }

    public double findMedian() {
        if (this.small.size() > this.big.size()) {
            return (double) this.small.peek();
        } else {
            return (((double) this.small.peek() + this.big.peek()) / 2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end
