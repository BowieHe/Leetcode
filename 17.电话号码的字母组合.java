import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) {
            return res;
        }
        backtrace(digits.toCharArray(), new StringBuilder(), 0);
        return res;
    }

    void backtrace(char[] digits, StringBuilder sb, int index) {
        if(sb.length() == digits.length) {
            res.add(sb.toString());
            return;
        }

        // for(int i = index; i < digits.length; i++) {
            Integer num = digits[index] - '0';
            char[] map = mapping[num].toCharArray();
            for(char c: map) {
                sb.append(c);
                backtrace(digits, sb, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        // }
    }
}
// @lc code=end

