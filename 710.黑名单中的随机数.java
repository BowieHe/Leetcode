import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start
class Solution {

    Random random = new Random();
    Set<Integer> s1;
    Set<Integer> s2;
    Map<Integer, Integer> map;
    int idx, max;

    public Solution(int n, int[] blacklist) {
        int m = blacklist.length;
        this.s1 = new HashSet<>();
        this.s2 = new HashSet<>();
        this.map = new HashMap<>();
        this.idx = n - m;
        this.max = n - m;
        for (int a : blacklist) {
            if (a < max) {
                s1.add(a);
            } else {
                s2.add(a);
            }
        }
    }

    public int pick() {

        int rand = random.nextInt(max);
        if (!s1.contains(rand)) {
            return rand;
        }
        if (!map.containsKey(rand)) {
            while (s2.contains(idx))
                idx++;
            map.put(rand, idx);
            idx++;
        }

        return map.get(rand);

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end
