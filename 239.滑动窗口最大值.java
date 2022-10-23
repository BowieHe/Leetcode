import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {

    class SingleList{
        LinkedList<Integer> res = new LinkedList<>();
        
        public void push(int n) {
            while(!res.isEmpty() && res.getLast() < n) {
                res.pollLast();
            }
            res.addLast(n);
        }

        public int getMax() {
            return res.getFirst();
        }

        public void pop(int n) {
            if(n == res.getFirst()) {
                res.pollFirst();
            }
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        SingleList windows = new SingleList();
        int[] res = new int[nums.length - k + 1];

        for(int i = 0;i < nums.length; i++) {
            if(i < k - 1) {
                windows.push(nums[i]);;
            } else {
                windows.push(nums[i]);
                res[i - k + 1] = windows.getMax();
                windows.pop(nums[i - k + 1]);
            }
        }

        return res;
    }
}
// @lc code=end

