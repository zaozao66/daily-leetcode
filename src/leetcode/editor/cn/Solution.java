package leetcode.editor.cn;

import java.util.Arrays;

class Solution {



    int m;
    int n;
    int[] rowCosts;
    int[] colCosts;
    int[][] arrs;
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        m = rowCosts.length;
        n = colCosts.length;
        this.rowCosts = rowCosts;
        this.colCosts = colCosts;
        arrs = new int[m][n];
        for (int i= 0; i< m; i++) {
            Arrays.fill(arrs[i], -1);
        }
        arrs[startPos[0]][startPos[1]] = 0;
        dfs(startPos[0], startPos[1], 0);
        return arrs[homePos[0]][homePos[1]];
    }

    public void dfs(int x, int y, int cost) {
        if (x >=0 && x < m && y >=0 && y < n && (arrs[x][y] == -1 || arrs[x][y] > cost)) {
            arrs[x][y] = cost;
            dfs(x+1, y, cost + rowCosts[x]);
            dfs(x-1, y, cost + rowCosts[x]);
            dfs(x, y+1, cost + colCosts[x]);
            dfs(x, y-1, cost + colCosts[x]);
        }
    }
}
