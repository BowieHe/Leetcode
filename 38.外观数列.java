/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        /*StringBuilder sb = new StringBuilder();
        int pre = 0;
        int curr = 1;
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n - 1);
        for(curr = 1; curr < str.length(); curr++){
            if(str.charAt(curr) != str.charAt(pre)){
                int count = curr - pre;
                sb.append(count).append(str.charAt(pre));
                pre = curr;
            }
        }
        if(pre != curr){
            if(str.charAt(curr) != str.charAt(pre)){
                int count = curr - pre;
                sb.append(count).append(str.charAt(pre));
            }
        }
        return sb.toString();*/
        StringBuilder s = new StringBuilder();
        int p1 = 0;
        int cur = 1;
        if ( n == 1 )
            return "1";
        String str = countAndSay(n - 1);
        for ( cur = 1; cur < str.length(); cur++ ) {
            if ( str.charAt(p1) != str.charAt(cur) ) {// 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
                int count = cur - p1;
                s.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }
        if ( p1 != cur ){// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            int count = cur - p1;
            s.append(count).append(str.charAt(p1));
        }
        return s.toString();

    }
}
// @lc code=end

