import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] p1, int[] p2) -> {
                    return p2[1] - p1[1];
                });
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new int[] { i, nums2[i] });
        }

        Arrays.sort(nums1);

        int left = 0, right = nums1.length - 1;
        int[] res = new int[nums1.length];

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0], val = p[1];
            if (val < nums1[right]) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }

        return res;

    }
}
// @lc code=end
