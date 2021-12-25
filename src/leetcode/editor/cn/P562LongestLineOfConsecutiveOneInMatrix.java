//给定一个01矩阵 M，找到矩阵中最长的连续1线段。这条线段可以是水平的、垂直的、对角线的或者反对角线的。 
//
// 示例: 
//
// 输入:
//[[0,1,1,0],
// [0,1,1,0],
// [0,0,0,1]]
//输出: 3
// 
//
// 提示: 给定矩阵中的元素数量不会超过 10,000。 
// Related Topics 数组 动态规划 矩阵 👍 50 👎 0

package leetcode.editor.cn;
// java: 矩阵中最长的连续1线段
// 2021-12-13 11:51:33
public class P562LongestLineOfConsecutiveOneInMatrix {
    public static void main(String[] args) {
        Solution solution = new P562LongestLineOfConsecutiveOneInMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] row = new int[m][n];
        int[][] col = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (i ==0) {
                        col[i][j] = 1;
                    }  else {
                        col[i][j] = col[i-1][j] + 1;
                    }
                    if (j == 0) {
                        row[i][j] = 1;
                    } else {
                        row[i][j] = row[i][j-1]+1;
                    }
                    if (i == 0 || j==0) {
                        left[i][j] = 1;
                    } else {
                        left[i][j] = left[i-1][j-1]+1;
                    }
                    if (i==0 || j == mat[0].length-1) {
                        right[i][j] = 1;
                    } else {
                        right[i][j] = right[i-1][j+1]+1;
                    }
                    res = Math.max(res, row[i][j]);
                    res = Math.max(res, col[i][j]);
                    res=Math.max(res, left[i][j]);
                    res=Math.max(res, right[i][j]);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}