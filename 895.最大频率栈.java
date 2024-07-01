import java.util.*;

/*
 * @lc app=leetcode.cn id=895 lang=java
 *
 * [895] 最大频率栈
 */

// @lc code=start
class FreqStack {

    int maxFreq;
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Deque<Integer>> group;

    public FreqStack() {
        this.maxFreq = 0;
        this.freq = new HashMap<Integer, Integer>();
        this.group = new HashMap<>();
    }

    public void push(int val) {
        int f = this.freq.getOrDefault(val, 0) + 1;
        this.freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);

        group.putIfAbsent(f, new ArrayDeque<Integer>());
        group.get(f).push(val);
    }

    public int pop() {
        int val = group.get(maxFreq).peek();
        freq.put(val, freq.get(val) - 1);
        group.get(maxFreq).pop();

        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end
