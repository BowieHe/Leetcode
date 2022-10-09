import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0]? b[1] - a[1] : a[0] - b[0];
            }
        });
        int n = envelopes.length;
        int[] height = new int[n];
        for(int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] heights) {
        int[] tail = new int[heights.length];
        int res = 0;
        for(int height: heights) {
            int left = 0, right = res;
            while(left < right) {//return when left equals to right
                int mid = left + (right - left) / 2;
                if(tail[mid] < height) {
                    left = mid + 1;
                } else {
                    // because the right bound is open
                    right = mid;
                }
            }
            // if height is less then the tailing one, height is the last one, 
            // else tail array would extend
            tail[left] = height;
            if(right == res) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

