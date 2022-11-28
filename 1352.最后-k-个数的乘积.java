/*
 * @lc app=leetcode.cn id=1352 lang=java
 *
 * [1352] 最后 K 个数的乘积
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    List<Integer> numbers = new ArrayList<>();

    public ProductOfNumbers() {
        this.numbers.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            this.numbers = new ArrayList<>();
            this.numbers.add(1);
            return;
        } 
        int n = numbers.size();
        numbers.add(numbers.get(n - 1) * num);
    }
    
    public int getProduct(int k) {
        int len = this.numbers.size() - 1;
        if(k > len) {
            return 0;
        }
        return numbers.get(len) / numbers.get(len - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end

