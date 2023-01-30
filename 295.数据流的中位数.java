import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {

    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;

    public MedianFinder() {
        high = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        low = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(low.size() >= high.size()) {
            low.offer(num);
            high.offer(low.poll());
        } else {
            high.offer(num);
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        System.out.print(high.peek());
        System.out.println(low.peek());

        if(low.size() > high.size()) {
            return low.peek();
        } else if(high.size() > low.size()) {
            return high.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
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

