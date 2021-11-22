//给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 
//mat[r][c] 的和： 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k 且 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 数组 矩阵 前缀和 👍 110 👎 0

package leetcode.editor.cn;
// java: 矩阵区域和
// 2021-11-22 16:10:11
public class P1314MatrixBlockSum {
    public static void main(String[] args) {
        Solution solution = new P1314MatrixBlockSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+1][1 + j] = sum[i][j+1]+sum[i+1][j]-sum[i][j]+mat[i][j];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int r2 = Math.min(m-1, i+k);
                int c1 = Math.max(j-k, 0);
                int c2 = Math.min(n-1, j+k);

                res[i][j] =  sum[r2+1][c2+1] - sum[r2+1][c1] - sum[r1][c2+1]+sum[r1][c1];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}