import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1631 lang=java
 *
 * [1631] 最小体力消耗路径
 */

// @lc code=start
class Solution {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[] { id - n, id, Math.abs(heights[i][j] - heights[i - 1][j]) });
                }
                if (j > 0) {
                    edges.add(new int[] { id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1]) });
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                return e1[2] - e2[2];
            };
        });

        int res = 0;
        UF uf = new UF(n * m);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.join(x, y);
            if (uf.connect(0, m * n - 1)) {
                res = v;
                break;
            }
        }

        return res;
    }

    class UF {
        int[] size;
        int[] parent;
        int n;

        UF(int n) {
            this.n = n;
            this.size = new int[n];
            this.parent = new int[n];
            Arrays.fill(this.size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public boolean join(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            }
            if (size[x] > size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[x] = y;
            size[y] += size[x];
            return true;
        }

        public boolean connect(int x, int y) {
            return find(x) == find(y);
        }
    }

    /*
     * public int minimumEffortPath(int[][] heights) {
     * int m = heights.length, n = heights[0].length;
     * 
     * List<int[]> edges = new ArrayList<int[]>();
     * for (int i = 0; i < m; i++) {
     * for (int j = 0; j < n; j++) {
     * int id = i * n + j;
     * if (i > 0) {
     * edges.add(new int[] { id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])
     * });
     * }
     * 
     * if (j > 0) {
     * edges.add(new int[] { id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])
     * });
     * }
     * }
     * }
     * 
     * Collections.sort(edges, new Comparator<int[]>() {
     * public int compare(int[] e1, int[] e2) {
     * return e1[2] - e2[2];
     * }
     * });
     * 
     * UF uf = new UF(n * m);
     * 
     * int ans = 0;
     * for (int[] edge : edges) {
     * int x = edge[0], y = edge[1], z = edge[2];
     * uf.join(x, y);
     * if (uf.connect(0, m * n - 1)) {
     * ans = z;
     * break;
     * }
     * }
     * return ans;
     * }
     * }
     * 
     * class UF {
     * int[] size;
     * int[] parent;
     * int n;
     * 
     * UF(int n) {
     * this.n = n;
     * this.size = new int[n];
     * this.parent = new int[n];
     * Arrays.fill(this.size, 1);
     * for (int i = 0; i < n; ++i) {
     * parent[i] = i;
     * }
     * }
     * 
     * public int find(int x) {
     * return parent[x] == x ? x : (parent[x] = find(parent[x]));
     * }
     * 
     * public boolean join(int x, int y) {
     * x = find(x);
     * y = find(y);
     * if (x == y) {
     * return false;
     * }
     * if (size[x] < size[y]) {
     * int temp = x;
     * x = y;
     * y = temp;
     * }
     * parent[y] = x;
     * size[x] += size[y];
     * return true;
     * }
     * 
     * public boolean connect(int x, int y) {
     * return find(x) == find(y);
     * }
     */
}
// @lc code=end
