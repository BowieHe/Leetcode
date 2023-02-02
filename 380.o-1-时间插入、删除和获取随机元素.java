import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {

    Random random;
    List<Integer> listVal;
    Map<Integer, Integer> mapVal;

    public RandomizedSet() {
        this.random = new Random();
        listVal = new ArrayList<>();
        this.mapVal = new HashMap<Integer, Integer>();

    }
    
    public boolean insert(int val) {
        if(mapVal.containsKey(val)) {
            return false;
        }
        listVal.add(val);
        mapVal.put(val, listVal.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(mapVal.containsKey(val)) {
            int index = mapVal.get(val);
            int lastVal = listVal.get(listVal.size() - 1);

            listVal.set(index, lastVal);
            mapVal.put(lastVal, index);

            listVal.remove(listVal.size() - 1);
            mapVal.remove(val);
            
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int index = random.nextInt(listVal.size());
        return listVal.get(index);
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

