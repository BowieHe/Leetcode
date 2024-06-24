/*
 * @lc app=leetcode.cn id=1352 lang=java
 *
 * [1352] 最后 K 个数的乘积
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    List<Integer> p;

    public ProductOfNumbers() {
        p = new ArrayList<>();
    }

    public void add(int num) {
        p.add(num);
    }

    public int getProduct(int k) {
        int index = p.size() - 1;
        int res = 1;
        for (int i = 0; i < k; i++) {
            int num = p.get(index - i);
            if (num == 0) {
                return 0;
            }
            res *= num;
        }
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end
