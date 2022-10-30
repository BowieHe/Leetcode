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
            // idx1[i] is the mines, if this is bigger than the mines value of nums2, 
            // then all the value in nums1 larger than nums2
            if(nums1[idx1[i]] > nums2[idx2[left]]) {
                res[idx2[left]] = nums1[idx1[i]];
                left++;
            } else {
                // if minus value in nums1 smaller than the minus value in nums2, 
                // this value in nums1 is smaller than all the number in nums2
                // so set this value to compare with the largest value of nums2
                res[idx2[right]] = nums1[idx1[i]];
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

