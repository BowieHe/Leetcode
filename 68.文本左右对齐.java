/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> temp = new ArrayList<>();
        int curLen = 0;
        for(String w: words) {
            if(curLen + temp.size() + w.length() > maxWidth) {
                res.add(combineString(temp, curLen, maxWidth, 0));
                temp = new ArrayList<>();
                curLen = 0;
            }
            temp.add(w);
            curLen += w.length();
        }

        if(temp.size() > 0) {
            res.add(combineString(temp, curLen, maxWidth, 1));
        }
        return res;
    }

    public String combineString(List<String> temp, int len, int maxWidth, int spaceLen) {
        StringBuilder sb = new StringBuilder();
        double space = temp.size() > 1?(maxWidth - len) / (temp.size() - 1.0):(maxWidth - len) ;
        int bigSpaceNum = temp.size() > 1?(maxWidth - len) % (temp.size() - 1): (maxWidth - len);
        for(int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i));
            
            int spaceNum = bigSpaceNum > 0? Double.valueOf(Math.ceil(space)).intValue(): Double.valueOf(Math.floor(space)).intValue();
            bigSpaceNum--;
            if(spaceLen > 0 && sb.length() < maxWidth) {
                sb.append(" ");
            } else if(i + 1 < temp.size()) {
                for(int j = 0; j < spaceNum; j++) {
                    sb.append(" ");
                }
            }
        }
        while(sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
// @lc code=end

