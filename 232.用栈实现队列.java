import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> reverse;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
        reverse = new Stack<Integer>();
    }
    
    private void shift() {
        if (reverse.isEmpty()) {
            while (!stack.isEmpty()) {
                reverse.push(stack.pop());
            }
        }
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shift();
        if(!reverse.isEmpty())
            return reverse.pop();
        throw new RuntimeException();
    }
    
    /** Get the front element. */
    public int peek() {
        shift();
        if(!reverse.isEmpty())
            return reverse.peek();
        throw new RuntimeException();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && reverse.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

