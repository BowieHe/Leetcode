import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {

        int len = nums1.length;
        Integer[] idx1 = new Integer[len], idx2 = new Integer[len];
        for(Integer i = 0; i < len; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        for(Integer a: idx1){System.out.println(a);}
        int[] res = new int[len];
        int left = 0, right = len - 1;

        for(int i = 0; i < len; i++) {
            if(nums1[idx1[i]] > nums2[idx2[left]]) {
                res[idx2[left]] = nums1[idx1[i]];
                left++;
            } else {
                res[idx2[right]] = nums1[idx1[i]];
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

