//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 541 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

// java: 01 矩阵
public class P542Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new P542Zero1Matrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] ==0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    res[i][j] = Math.min(res[i][j], res[i-1][j] + 1);
                }
                if (j - 1 >=0) {
                    res[i][j] = Math.min(res[i][j], res[i][j-1] + 1);
                }
            }
        }

        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                if (i+1<m) {
                    res[i][j] = Math.min(res[i][j], res[i+1][j] + 1);
                }
                if (j+1<n) {
                    res[i][j] = Math.min(res[i][j], res[i][j+1] + 1);
                }
            }
        }
        return res;
    }

        /**
         * bfs解决
         * @param mat
         * @return
         */
    public int[][] updateMatrixByBfs(int[][] mat) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] result = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = now[0] + dirs[i][0];
                int b = now[1] + dirs[i][1];
                if (a >= 0 && a < m && b>=0 && b<n && !seen[a][b]) {
                    result[a][b] = result[now[0]][now[1]] + 1;
                    queue.offer(new int[]{a,b});
                    seen[a][b] = true;
                }
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}