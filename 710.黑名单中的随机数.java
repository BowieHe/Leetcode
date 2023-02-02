import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start
class Solution {

    Random random;
    int len, m, index;
    HashSet<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
    Map<Integer, Integer> val = new HashMap<>();

    public Solution(int n, int[] blacklist) {
        random = new Random();
        len = n;
        m = blacklist.length;
        index = n - m;
        for(int num: blacklist) {
            if(num < index) s1.add(num);
            else s2.add(num);
        }
    }
    
    public int pick() {
        
        int num = random.nextInt(len - m);
        if(!s1.contains(num)) return num;

        if(!val.containsKey(num)) {
            while(s2.contains(index)) index++;
            val.put(num, index++);
        }

        return val.get(num);
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end

