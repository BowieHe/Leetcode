import java.util.HashMap;
import java.util.Map;
import java.util.*;

/*
 * @lc app=leetcode.cn id=895 lang=java
 *
 * [895] 最大频率栈
 */

// @lc code=start
class FreqStack {

    int maxFreq;
    Map<Integer, Integer> valToFreq;
    Map<Integer, Stack<Integer>> freqToVal;

    public FreqStack() {
        this.valToFreq = new HashMap<>();
        this.freqToVal = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        Stack<Integer> freqVal = freqToVal.getOrDefault(freq, new Stack<Integer>());
        freqVal.push(val);
        freqToVal.put(freq, freqVal);
    }
    
    public int pop() {
        // System.out.print(maxFreq);
        Stack<Integer> freqVal = freqToVal.get(maxFreq);
        // System.out.print("===");
        // System.out.println(freqVal.peek());
        int val = freqVal.pop();
        valToFreq.put(val, valToFreq.get(val) - 1);
        if(!freqVal.empty()) {
            freqToVal.put(maxFreq, freqVal);
        } else {
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

