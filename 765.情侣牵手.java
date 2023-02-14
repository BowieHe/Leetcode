/*
 * @lc app=leetcode.cn id=765 lang=java
 *
 * [765] 情侣牵手
 */

// @lc code=start
class Solution {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        UnionFind uf = new UnionFind(len / 2);
        for(int i = 0; i < len; i += 2) {
            uf.union((row[i] / 2), (row[i + 1] / 2));
        }

        return (len / 2) - uf.getCount();
    }

    class UnionFind{ 
        int[] parent;
        int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) {
                return;
            }

            parent[rootx] = rooty;
            count--;
        }

        public int find(int x) {
            while(x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
// @lc code=end

