import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int first = 0, second = 0;
        while (first < firstList.length && second < secondList.length) {
            int[] f = firstList[first];
            int[] s = secondList[second];
            if (f[1] < s[0]) {
                first++;
            } else if (s[1] < f[0]) {
                second++;
            } else {
                int min = Math.max(f[0], s[0]);
                int max = Integer.MIN_VALUE;
                if (f[1] > s[1]) {
                    second++;
                    max = s[1];
                } else {
                    first++;
                    max = f[1];
                }
                res.add(new int[] { min, max });

            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
// @lc code=end
