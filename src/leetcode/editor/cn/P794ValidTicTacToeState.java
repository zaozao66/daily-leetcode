//给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。 
//
// 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（' '）中。 
// 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。 
// 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = ["O  ","   ","   "]
//输出：false
//解释：玩家 1 总是放字符 "X" 。
// 
//
// 示例 2： 
//
// 
//输入：board = ["XOX"," X ","   "]
//输出：false
//解释：玩家应该轮流放字符。 
//
// 示例 3： 
//
// 
//输入：board = ["XXX","   ","OOO"]
//输出：false
// 
//
// Example 4: 
//
// 
//输入：board = ["XOX","O O","XOX"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// board.length == 3 
// board[i].length == 3 
// board[i][j] 为 'X'、'O' 或 ' ' 
// 
// Related Topics 数组 字符串 👍 67 👎 0

package leetcode.editor.cn;
// java: 有效的井字游戏
// 2021-12-09 13:53:27
public class P794ValidTicTacToeState {
    public static void main(String[] args) {
        Solution solution = new P794ValidTicTacToeState().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validTicTacToe(String[] board) {
        return validSuc(board);
    }

    public boolean validSuc(String[] board) {
        int numO = 0;
        int numX = 0;
        for (String s : board) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    numO++;
                } else if (s.charAt(j) == 'X') {
                    numX++;
                }
            }
        }
        if (numO != numX && numO != numX-1) {
            return false;
        }

        int flagX = 0;
        int flagO = 0;
        for (String s : board) {
            if (s.equals("XXX")) {
                flagX++;
            } else if (s.equals("OOO")) {
                flagO++;
            }
        }
        for (int i = 0; i < board[0].length(); i++) {
            if (sucHelper(board[0].charAt(i), board[1].charAt(i),board[2].charAt(i), 'X')) {
                flagX++;
            } else if (sucHelper(board[0].charAt(i), board[1].charAt(i),board[2].charAt(i), 'O')) {
                flagO++;
            }
        }

        if (sucHelper(board[0].charAt(0), board[1].charAt(1),board[2].charAt(2), 'X') || sucHelper(board[0].charAt(2), board[1].charAt(1),board[2].charAt(0), 'X')) {
            flagX++;
        }
        if (sucHelper(board[0].charAt(0), board[1].charAt(1),board[2].charAt(2), 'O') || sucHelper(board[0].charAt(2), board[1].charAt(1),board[2].charAt(0), 'O')) {
            flagO++;
        }
        if ((numO == numX && flagX > 0) || (numO == numX-1 && flagO > 0)) {
            return false;
        }
        return !(flagX > 0 && flagO > 0);
    }

    public boolean sucHelper(char c1, char c2, char c3, char t) {
        return c1 == t && c2 == t && c3 == t;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}