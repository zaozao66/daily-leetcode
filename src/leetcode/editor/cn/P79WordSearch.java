//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1106 👎 0

package leetcode.editor.cn;
// java: 单词搜索
// 2021-12-06 19:20:26
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] flag;
        boolean res = false;
        public boolean exist(char[][] board, String word) {
            flag = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        dfs(board, word, 0, i,j);
                        if (res) {
                            return true;
                        }
                    }
                }
            }
            return res;
        }

        public void dfs(char[][] board, String word, int cur, int x, int y) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length ||board[x][y] != word.charAt(cur) || flag[x][y]) {
                return;
            }
            if (word.charAt(cur) == board[x][y]) {
                flag[x][y] = true;
                if (cur == word.length() -1) {
                    res = true;
                } else {
                    dfs(board, word, cur +1, x-1, y);
                    dfs(board, word, cur +1, x+1, y);
                    dfs(board, word, cur +1, x, y+1);
                    dfs(board, word, cur +1, x, y-1);

                }
                flag[x][y] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}