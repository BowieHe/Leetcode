import java.util.*;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {

    Map<Integer, Integer> set;
    List<Integer> list;

    public RandomizedSet() {
        this.set = new HashMap<Integer, Integer>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (set.containsKey(val)) {
            return false;
        } else {
            set.put(val, list.size());
            list.add(val);
            return true;
        }

    }

    public boolean remove(int val) {
        if (set.containsKey(val)) {

            int index = set.get(val);

            int last = list.get(list.size() - 1);
            list.set(index, last);
            set.put(last, index);
            set.remove(val);
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }

    }

    public int getRandom() {
        return list.get((int) (Math.random() * (list.size())));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
