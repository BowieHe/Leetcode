import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || n < 4) {
            return res;
        }
        for(int i = 0; i < n -3; i++) {
            
            System.out.println("current turn" + i);

            if(((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) {

                System.out.println("skip because i is too large");
                continue;
            } else if(((long)nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3]) < target) {

                System.out.println(nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3]);
                System.out.println("skip because i is too small");
                continue;
            } 
            
             if(i > 0 && nums[i] == nums[i - 1]) {
                System.out.println("skip i");
                continue;
            }
            for(int j = i + 1; j < n - 2; j++) {
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    System.out.println("skip because j is too large");
                    continue;
                } else if(nums[i] + nums[j] + nums[n - 1] + nums[n -2] < target) {

                    System.out.println("skip because j is too small");
                    continue;
                }
                System.out.println("currentJ"+ j);
                if(j > i + 1 && nums[j] == nums[j - 1]) {

                    // System.out.println("test run");
                    continue;
                }
                int lo = j + 1, hi = n - 1;
                while(lo < hi) {
                    System.out.println("current lo" + lo + "hi :" + hi);
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if(sum < target) {
                        lo = removeDup(true, lo, nums);
                        lo++;
                    } else if(sum > target) {
                        hi = removeDup(false, hi, nums);
                        hi--;
                    } else { // sum == target   
                        System.out.println(i + " " + j + " " + lo + " " + hi);
                        List<Integer> curRes = new ArrayList<>();
                        curRes.add(nums[i]);
                        curRes.add(nums[j]);
                        curRes.add(nums[lo]);
                        curRes.add(nums[hi]);
                        res.add(curRes);
                        lo = removeDup(true, lo, nums);
                        hi = removeDup(false, hi, nums);
                        lo++;
                        hi--;
                    }
                }
            }
           
        }
        return res;
    }

    Integer removeDup(Boolean incr, int start, int[] nums) {
        if(incr) {
            while(start < (nums.length - 1) && nums[start] == nums[start + 1]) {
                start++;
            }
        } else {
            while(start > 1 && nums[start] == nums[start - 1]) {
                start--;
            }
        }
        return start;
    }
}
// @lc code=end

