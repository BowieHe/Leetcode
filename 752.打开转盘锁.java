import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String d: deadends) {
            deads.add(d);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();

                if(target.equals(cur)) {
                    return step;
                }
                if(deads.contains(cur)) {
                    continue;
                }

                for(int j = 0; j < 4; j++) {
                    String add = plus(cur, j);
                    if(!visited.contains(add)) {
                        visited.add(add);
                        q.offer(add);
                    }
                    String minus = minus(cur, j);
                    if(!visited.contains(minus)) {
                        visited.add(minus);
                        q.offer(minus);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    String plus(String s, int index) {
        char[] ch = s.toCharArray();
        if(ch[index] == '9') {
            ch[index] = '0';
        } else {
            ch[index] += 1;
        }

        return new String(ch);
    }

    String minus(String s, int index) {
        char[] ch = s.toCharArray();
        if(ch[index] == '0') {
            ch[index] = '9';
        } else {
            ch[index] -= 1;
        }

        return new String(ch);
    }
}
// @lc code=end

