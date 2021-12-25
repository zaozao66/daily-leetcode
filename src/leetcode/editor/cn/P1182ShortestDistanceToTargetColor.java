//给你一个数组 colors，里面有 1、2、 3 三种颜色。 
//
// 我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。 
//
// 现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。 
//
// 如果不存在解决方案，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//输出：[3,0,3]
//解释： 
//距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
//距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
//距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。
// 
//
// 示例 2： 
//
// 输入：colors = [1,2], queries = [[0,3]]
//输出：[-1]
//解释：colors 中没有颜色 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= colors.length <= 5*10^4 
// 1 <= colors[i] <= 3 
// 1 <= queries.length <= 5*10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] < colors.length 
// 1 <= queries[i][1] <= 3 
// 
// Related Topics 数组 二分查找 动态规划 👍 30 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// java: 与目标颜色间的最短距离
// 2021-12-13 13:50:05
public class P1182ShortestDistanceToTargetColor {
    public static void main(String[] args) {
        Solution solution = new P1182ShortestDistanceToTargetColor().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] dp = new int[colors.length+2][3];
        dp[0][0] = -1;
        dp[0][1] = -1;
        dp[0][2] = -1;
        dp[colors.length+1][0] = -1;
        dp[colors.length+1][1] = -1;
        dp[colors.length+1][2] = -1;
        for (int i = 1; i <= colors.length; i++) {
            if (colors[i-1] == 1) {
                dp[i][0]=0;
            } else {
                dp[i][0] = dp[i-1][0] == -1?-1:dp[i-1][0]+1;
            }
            if (colors[i-1] == 2) {
                dp[i][1]=0;
            } else {
                dp[i][1] = dp[i-1][1] == -1?-1:dp[i-1][1]+1;
            }
            if (colors[i-1] == 3) {
                dp[i][2]=0;
            } else {
                dp[i][2] = dp[i-1][2] == -1?-1:dp[i-1][2]+1;
            }
        }
        for (int i = colors.length; i > 0; i--) {
            if (colors[i-1] == 1) {
                dp[i][0]=0;
            } else {
                dp[i][0] = compare(dp[i+1][0] == -1?-1:dp[i+1][0]+1, dp[i][0]);
            }
            if (colors[i-1] == 2) {
                dp[i][1]=0;
            } else {
                dp[i][1] = compare(dp[i+1][1] == -1?-1:dp[i+1][1]+1, dp[i][1]);
            }
            if (colors[i-1] == 3) {
                dp[i][2]=0;
            } else {
                dp[i][2] = compare(dp[i+1][2] == -1?-1:dp[i+1][2]+1, dp[i][2]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(dp[queries[i][0] +1][queries[i][1]-1]);
        }
        return res;
    }

    public int compare(int a, int b) {
        if (a == -1) {
            return b;
        }
        if (b==-1) {
            return a;
        }
        return Math.min(a,b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}