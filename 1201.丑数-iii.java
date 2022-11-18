/*
 * @lc app=leetcode.cn id=1201 lang=java
 *
 * [1201] 丑数 III
 */

// @lc code=start
class Solution {
   public int nthUglyNumber(int n, int a, int b, int c) {
        int right = (int)2e9;
        int left = 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            // System.out.println(mid);
            // long num = (long)(mid / a) + (long)(mid / b) + (long)(mid / c) - (long)(mid / lcm(a, b)) - (long)(mid / lcm(a, c)) - (long)(mid / lcm(b, c)) + (long)(mid / );
            if(f(mid, a, b, c) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    long f(int num, int a, int b, int c) {
        long setA = num /a, setB = num/b, setC = num /c;
        long setAB = num / lcm(a, b);
        long setAC = num / lcm(a, c);
        long setBC = num /lcm(b, c);
        long setABC = num /lcm(lcm(a, b), c);
        return setA + setB + setC - setAB - setAC - setBC + setABC;
    }

    long lcm(long a, long b){
        // System.out.println(String.format("%s, %s", a, b));
        return a * b / gcd(a, b);
    }

    long gcd(long a , long b){
        //  System.out.println(String.format("%s, %s", a, b));
        //  System.out.println(b);
        if(a < b) {
            return gcd(b, a);
        }
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    } 
}
// @lc code=end

