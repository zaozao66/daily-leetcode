//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1427 👎 0

package leetcode.editor.cn;
// java: 岛屿数量
// 2021-11-29 22:26:09
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!flag[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, flag, i+1, j);
                    dfs(grid, flag, i, j+1);
                }
                flag[i][j] = true;
            }
        }
        return res;
    }

    public void dfs(char[][] grid, boolean[][] flag, int x, int y) {
        if (x >= 0 && x < grid.length&& y >=0 && y< grid[0].length && !flag[x][y] && grid[x][y]=='1') {
            flag[x][y] = true;
            dfs(grid, flag, x+1, y);
            dfs(grid, flag, x-1, y);
            dfs(grid, flag, x, y+1);
            dfs(grid, flag, x, y-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}