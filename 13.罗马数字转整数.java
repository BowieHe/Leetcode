/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start

class Solution {
    public int romanToInt(String s) {
        int ans = 0, pre = getValue(s.charAt(0)), curr = getValue(s.charAt(0));
        //int ans = temp;
        for(int i=0; i<s.length(); i++){
            curr = getValue(s.charAt(i));
            if(pre < curr){
                ans += (curr - 2*pre);
            }else{
                ans += curr;
            }
            pre = curr;
        }
        return ans;
    }

    private int getValue(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
// @lc code=end

