//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 671 👎 0

package leetcode.editor.cn;
// java: 被围绕的区域
// 2021-12-02 11:52:54
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        boolean[][] visited;
        public void solve(char[][] board) {
//            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if ((i==0 || i== board.length-1 || j == 0 || j ==board[0].length-1) && board[i][j]=='O') {
                        dfs(board, i,j);
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j]=='O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] =='A') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x> board.length-1 || y < 0 || y > board[0].length-1 || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x+1, y);
            dfs(board, x-1, y);
            dfs(board, x, y+1);
            dfs(board, x, y-1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}