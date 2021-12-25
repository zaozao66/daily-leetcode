//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 561 👎 0

package leetcode.editor.cn;
// java: 矩阵中的最长递增路径
// 2021-12-14 10:29:22
public class P329LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new P329LongestIncreasingPathInAMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] matrix;
        int[][] seen;
        int res = 0;
        public int longestIncreasingPath(int[][] matrix) {
            this.matrix = matrix;
            seen = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (seen[i][j] == 0) {
                        dfs(i,j,1);
                    }
                }
            }
            return res;
        }

        public void dfs(int x, int y, int ans) {
            seen[x][y] = ans;
            res = Math.max(res, ans);
            if (x+1 < matrix.length && seen[x+1][y] < ans+ 1 && matrix[x+1][y] > matrix[x][y]) {
                dfs(x+1, y, ans+1);
            }
            if (x-1 >=0 && seen[x-1][y] < ans+ 1 && matrix[x-1][y] > matrix[x][y]) {
                dfs(x-1, y, ans+1);
            }
            if (y-1 >=0 && seen[x][y-1] < ans+ 1 && matrix[x][y-1] > matrix[x][y]) {
                dfs(x, y-1, ans+1);
            }
            if (y+1 < matrix[0].length && seen[x][y+1] < ans+ 1 && matrix[x][y+1] > matrix[x][y]) {
                dfs(x, y+1, ans+1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}