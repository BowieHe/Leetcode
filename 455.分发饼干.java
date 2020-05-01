import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = g.length - 1, bis = s.length - 1;
        int count = 0;
        while(child >= 0 && bis >= 0){
            if(s[bis] >= g[child]){
                count++;
                bis--;
                child--;
            }else {
                child--;
            }
        }
        return count;
    }
}
// @lc code=end

