//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 👍 1384 👎 0

package leetcode.editor.cn;

import javax.swing.*;

// java: 乘积最大子数组
// 2021-12-05 10:16:33
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        solution.maxProduct(new int[]{-4,-3,-2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pos = 0, neg = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos = Math.max(pos * nums[i], nums[i]);
                neg = neg * nums[i];
            } else {
                int tem = pos;
                pos = neg * nums[i];
                neg = Math.min(tem * nums[i], nums[i]);
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}