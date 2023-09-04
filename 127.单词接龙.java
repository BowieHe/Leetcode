/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    class Node{
        String str;
        int val;
        Node(String _str, int _val) {
            this.str = _str;
            this.val = _val;
        }
    }

    private String s, e;
    Set<String> set = new HashSet<String>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        s = beginWord;
        e = endWord;
        for(String w : wordList) {
            set.add(w);
        }
        if(!set.contains(e)) return 0;

        int res = bfs();
        return res == -1? 0: res + 1;
    }

    int bfs() {
        // d1 stand for start queue, s2 stand for end queue
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        // m1 stand for res from start, m2 stand for res from end
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();

        d1.add(s);
        d2.add(e);
        m1.put(s, 0);
        m2.put(e, 0);

        int t = -1;

        while(!d1.isEmpty() && !d2.isEmpty()) {
            if(d1.size() > d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }

            if(t != -1) return t;
        }

        return -1;
    }


    int update(Deque<String> d, Map<String, Integer> cur, Map<String, Integer> reverse) {
        int len = d.size();
        while(len-- > 0) {
            String s = d.poll();
            int n = s.length();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < 26; j++) {
                    if(set.contains(s)) {
	                    String replace = s.substring(0, i) + String.valueOf((char)('a' + j)) + s.substring(i + 1);
	                    // this one already been recorded
	                    if(cur.containsKey(replace) && cur.get(replace) <= cur.get(s) + 1) continue;                    
	
                        // this key has been processed by the other side, got the result
	                    if(reverse.containsKey(replace)) {
	                        return cur.get(s) + 1 + reverse.get(replace);
	                    } else {
                            // add the element into deque, update the map
	                        d.addLast(replace);
                            cur.put(replace, cur.get(s) + 1);
	                    }
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end

