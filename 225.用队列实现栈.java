import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
   Queue<Integer> q = new LinkedList<>();
   int top_elem = 0;
   
   public void push(int x) {
    q.offer(x);
    top_elem = x;
   }

   public int top() {
    return top_elem;
   }

   public int pop() {
    int size = q.size();
    while(size > 2) {
        q.offer(q.poll());
        size--;
    }
    top_elem = q.peek();
    q.offer(q.poll());
    return q.poll();
   }

   public boolean empty() {
    return q.isEmpty();
   }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

