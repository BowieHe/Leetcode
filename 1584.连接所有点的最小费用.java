import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1584 lang=java
 *
 * [1584] 连接所有点的最小费用
 */

// @lc code=start
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        UF uf = new UF(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{
                    i , j, Math.abs(xi - xj) + Math.abs(yj - yi)
                });
            }
        }

        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });
        int mst = 0;
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if(uf.connected(u, v)) {
                continue;
            }
            mst += weight;
            uf.connect(u, v);
        }
        return mst;
    }

    class UF {
        int count;
        int[] parent;
        
        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int n) {
            while(n != parent[n]) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        void connect(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }

        public boolean connected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }
    }
}
// @lc code=end

