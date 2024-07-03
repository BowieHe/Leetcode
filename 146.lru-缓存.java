/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;

class LRUCache {

    Node head = new Node();
    Node tail = new Node();
    int capacity;
    int curNum;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curNum = 0;
        this.map = new HashMap<>();
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);

        } else {
            remove();

            Node n = new Node(key, value);
            moveToHead(n);

            map.put(key, n);
            curNum++;
        }

    }

    void remove() {
        if (curNum < capacity) {
            return;
        }

        Node pre = tail.pre;

        pre.pre.next = tail;
        tail.pre = pre.pre;
        map.remove(pre.key);
        curNum--;
    }

    public void moveToHead(Node node) {
        if (node.pre != null && node.next != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    class Node {
        Node pre;
        Node next;
        int key;
        int value;

        Node() {
            this.key = -1;
            this.value = -1;
            this.pre = null;
            this.next = null;
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
