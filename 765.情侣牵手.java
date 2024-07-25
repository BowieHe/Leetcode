/*
 * @lc app=leetcode.cn id=765 lang=java
 *
 * [765] 情侣牵手
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSwapsCouples(int[] row) {
        int count = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            m.put(row[i], i);
        }

        for (int i = 0; i < row.length; i += 2) {
            int required = row[i] % 2 == 1 ? row[i] - 1 : row[i] + 1;
            int index = m.get(required);
            if (index - i == 1) {
                // already match
                continue;
            } else {
                int preVal = row[i + 1];
                row[i + 1] = required;
                m.put(required, i + 1);

                row[index] = preVal;
                m.put(preVal, index);
                count++;
            }
        }

        return count;
    }
}
// @lc code=end
