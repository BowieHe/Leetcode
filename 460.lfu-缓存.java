/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start
import java.util.*;

class LFUCache {

    // key to values
    Map<Integer, Integer> kv;
    // key to frequency
    Map<Integer, Integer> kf;
    // frquency to keys
    Map<Integer, LinkedHashSet<Integer>> fk;

    int cap;
    int minFreq;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.kv = new HashMap<>();
        this.kf = new HashMap<>();
        this.fk = new HashMap<>();
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(this.kv.containsKey(key)) {
            addFrequency(key);
            return kv.get(key);
        }
        System.out.println("key not exist " + key);
        return -1;
    }
    
    public void put(int key, int value) {
        // key already exist, or capacity is not full, add values
        if(this.kv.size() < cap || this.kv.containsKey(key)) {
            kv.put(key, value);
            addFrequency(key);
        } else if(cap > 0){
            // keySet is full, need to remove
            int minKey = this.fk.get(minFreq).iterator().next();
            // Iterator it = this.fk.get(minFreq).iterator();
            // System.out.print("== get list values ");
            // while(it.hasNext()) {
            //     System.out.print("=" + it.next() + "=");
            // }
            System.out.println(" add key " + key + " and get minFreq " + minFreq + " remove min key " + minKey);
            this.fk.get(minFreq).remove(minKey);
            this.kv.remove(minKey);
            this.kf.remove(minKey);
            this.minFreq = 1;
            this.kv.put(key, value);
            this.kf.put(key, 1);
            this.fk.putIfAbsent(1, new LinkedHashSet<>());
            this.fk.get(1).add(key);
        }
    }

    void addFrequency(int key) {
        int freq = this.kf.getOrDefault(key, 0);
        this.kf.put(key, freq + 1);
        this.fk.putIfAbsent(freq + 1, new LinkedHashSet<>());
        this.fk.get(freq + 1).add(key);
        if(freq == 0 || this.minFreq == 0) {
            this.minFreq = 1;
        } else if(freq > 0) {
            
            this.fk.get(freq).remove(key);
            if(this.fk.get(freq).isEmpty() && this.minFreq == freq) {
                this.minFreq++;
            }
        }
        System.out.println("add frequency for key " + key + " with value " + (freq + 1) + " with min freq " + minFreq );
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

