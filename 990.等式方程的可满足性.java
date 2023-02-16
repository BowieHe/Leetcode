/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for(String eq: equations) {
            if(eq.charAt(1) == '=') {
                char x =eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        for(String eq: equations) {
            if(eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.isConnect(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;

    }

    class UF {
        int count;
        private int[] parent;
        private int[] size;
        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) {
                return;
            }

            if(size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean isConnect(int x, int y) {
            int rootP = find(x);
            int rootQ = find(y);
            return rootP == rootQ;
        }
        private int find(int n) {
            while(parent[n] != n) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }
    }
}
// @lc code=end

