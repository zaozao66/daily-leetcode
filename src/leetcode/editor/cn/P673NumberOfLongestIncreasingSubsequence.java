//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 👍 512 👎 0

package leetcode.editor.cn;
// java: 最长递增子序列的个数
// 2021-12-08 10:15:15
public class P673NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P673NumberOfLongestIncreasingSubsequence().new Solution();
        solution.findNumberOfLIS(new int[]{2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] +1 > dp[i]) {
                        dp[i] = dp[j] +1;
                        count[i] = count[j];
//                        max = Math.max(dp[i], max);

                    } else if (dp[j] +1 == dp[i]) {
                        count[i] = count[i] + count[j];
                    }
                }

            }
            if (dp[i] > max) {
                max = dp[i];
                res = count[i];
            } else if (dp[i] == max) {
                res += count[i];
            }

        }
//        for (int i = 0; i < nums.length; i++) {
//            if (dp[i] == max) {
//                res += count[i];
//            }
//        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}