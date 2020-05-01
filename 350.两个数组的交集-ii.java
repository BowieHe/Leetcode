import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = 0, len2 = 0, k = 0;
        while(len1 < nums1.length && len2 < nums2.length){
            if(nums1[len1] < nums2[len2])
                len1++;
            else if(nums1[len1] > nums2[len2])
                len2++;
            else{
                nums1[k++] = nums1[len1++];
                len2++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
// @lc code=end

