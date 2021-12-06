//给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。 
//
// 示例 1： 
//
// 输入：[1,0,1,1,0]
//输出：4
//解释：翻转第一个 0 可以得到最长的连续 1。
//     当翻转以后，最大连续 1 的个数为 4。
// 
//
// 
//
// 注： 
//
// 
// 输入数组只包含 0 和 1. 
// 输入数组的长度为正整数，且不超过 10,000 
// 
//
// 
//
// 进阶： 
//如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？ 
// Related Topics 数组 动态规划 滑动窗口 👍 84 👎 0

package leetcode.editor.cn;
// java: 最大连续1的个数 II
// 2021-12-06 09:03:41
public class P487MaxConsecutiveOnesIi {
    public static void main(String[] args) {
        Solution solution = new P487MaxConsecutiveOnesIi().new Solution();
        solution.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = -1, right = -1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (right == -1) {
                    right = i;
                } else {
                    res = Math.max(res, i-left-1);
                    left = right;
                    right = i;
                }
            }
        }
        return Math.max(res, nums.length - left -1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}