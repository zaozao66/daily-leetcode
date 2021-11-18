//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 449 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

// java: 腐烂的橘子
// 2021-11-17 17:57:52
public class P994RottingOranges {
    public static void main(String[] args) {
        Solution solution = new P994RottingOranges().new Solution();
        int[][] ints = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        solution.orangesRotting(ints);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 可以用橘子数量count做优化
         * @param grid
         * @return
         */
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean flag =false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            return 0;
        }
        int result = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            flag =false;
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int a = now[0] + dirs[j][0];
                    int b = now[1] + dirs[j][1];
                    if (a >=0 && a<m && b>=0 && b<n && grid[a][b]==1) {
                        flag = true;
                        grid[a][b]=2;
                        queue.offer(new int[]{a,b});
                    }
                }
            }
            if (!flag) {
                break;
            } else {
                result++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}