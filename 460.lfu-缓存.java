/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start
import java.util.*;

class LFUCache {

    int cap;
    int curNum;
    int minFreq;
    Map<Integer, Node> map;
    Map<Integer, LinkedHashSet<Node>> group;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;
        this.curNum = 0;
        this.map = new HashMap<>();
        this.group = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            freqPlus(node);
            return node.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            freqPlus(node);
        } else {

            eliminate();

            Node cur = new Node(key, value, 1);
            map.put(key, cur);
            group.putIfAbsent(1, new LinkedHashSet<>());
            group.get(1).add(cur);
            minFreq = 1;
            curNum++;
        }

    }

    void freqPlus(Node node) {
        int preFreq = node.freq;
        group.get(preFreq).remove(node);
        if (group.get(preFreq).isEmpty() && minFreq == preFreq) {
            minFreq++;
        }
        node.freq++;
        group.putIfAbsent(node.freq, new LinkedHashSet<>());
        group.get(node.freq).add(node);

    }

    void eliminate() {
        if (curNum < cap) {
            return;
        }
        Set<Node> preList = group.get(minFreq);
        Node remove = preList.iterator().next();
        preList.remove(remove);
        map.remove(remove.key);
        curNum--;

    }

    class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
