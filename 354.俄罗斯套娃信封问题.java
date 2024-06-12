import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });

        List<Integer> res = new ArrayList<>();
        res.add(envelopes[0][1]);
        for (int i = 0; i < envelopes.length; i++) {
            int num = envelopes[i][1];
            if (num > res.get(res.size() - 1)) {
                res.add(num);
            } else {
                int index = bs(res, num);
                res.set(index, num);
            }
        }

        return res.size();
    }

    public int bs(List<Integer> res, int num) {
        int left = 0, right = res.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (res.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end
