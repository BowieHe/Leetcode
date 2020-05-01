import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int len1 = 0, len2 = 0;
        while(len1 < nums1.length && len2 < nums2.length){
            if(nums1[len1] == nums2[len2]){
                set.add(nums1[len1]);
                len1++;
                len2++;
            }
            else if(nums1[len1] > nums2[len2])
                len2++;
            else
                len1++;
            continue;
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for(int n: set){
            ans[index++] = n;
        }
        return ans;
    }
}
// @lc code=end

