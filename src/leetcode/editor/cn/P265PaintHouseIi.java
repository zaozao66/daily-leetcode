//假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此
//类推。请你计算出粉刷完所有房子最少的花费成本。 
//
// 注意： 
//
// 所有花费均为正整数。 
//
// 示例： 
//
// 输入: [[1,5,3],[2,9,4]]
//输出: 5
//解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5; 
//     或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5. 
// 
//
// 进阶： 
//您能否在 O(nk) 的时间复杂度下解决此问题？ 
// Related Topics 数组 动态规划 👍 103 👎 0

package leetcode.editor.cn;
// java: 粉刷房子 II
// 2021-12-03 09:51:03
public class P265PaintHouseIi {
    public static void main(String[] args) {
        Solution solution = new P265PaintHouseIi().new Solution();
        solution.minCostII(new int[][]{{1,5,3}, {2,9,4}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostII(int[][] costs) {
            if (costs[0].length ==1) {
                int res = 0;
                for (int[] cost : costs) {
                    res += cost[0];
                }
                return res;
            }
            int min = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int mid = -1, mid2 = -1;
            int res = 0, res2 = 0, rid = -1, rid2 = -1;
            int temp;
            for (int i = 0; i < costs.length; i++) {
                min = Integer.MAX_VALUE;
                min2 = Integer.MAX_VALUE;
                for (int j = 0; j < costs[0].length; j++) {
                    if (j == rid) {
                        temp = costs[i][j] + res2;
                    } else {
                        temp = costs[i][j] + res;
                    }
                    if (temp <= min) {
                        min2 = min;
                        mid2 = mid;
                        min = temp;
                        mid = j;
                    } else if (temp < min2) {
                        min2 = temp;
                        mid2 = j;
                    }
                }
                res = min;
                res2 = min2;
                rid = mid;
            }
            return Math.min(min, min2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}