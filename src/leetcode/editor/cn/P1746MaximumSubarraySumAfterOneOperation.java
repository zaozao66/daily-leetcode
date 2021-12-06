//你有一个整数数组 nums。你只能将一个元素 nums[i] 替换为 nums[i] * nums[i]。 
//
// 返回替换后的最大子数组和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,-1,-4,-3]
//输出：17
//解释：你可以把-4替换为16(-4*(-4))，使nums = [2,-1,16,-3]. 现在，最大子数组和为 2 + -1 + 16 = 17. 
//
// 示例 2： 
//
// 
//输入：nums = [1,-1,1,1,-1,-1,1]
//输出：4
//解释：你可以把第一个-1替换为1，使 nums = [1,1,1,1,-1,-1,1]. 现在，最大子数组和为 1 + 1 + 1 + 1 = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 动态规划 👍 12 👎 0

package leetcode.editor.cn;
// java: 经过一次操作后的最大子数组和
// 2021-12-06 09:30:20
public class P1746MaximumSubarraySumAfterOneOperation {
    public static void main(String[] args) {
        Solution solution = new P1746MaximumSubarraySumAfterOneOperation().new Solution();
        solution.maxSumAfterOperation(new int[]{1,-1,1,1,-1,-1,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int a = nums[0];
        int b = nums[0] *nums[0];
        int c = nums[0];
        int res = nums[0] * nums[0];
        for (int i = 1; i < nums.length; i++) {
            c = Math.max(b > 0? b+ nums[i] : nums[i], c > 0? c + nums[i] : nums[i]);
            b = a > 0 ? a + nums[i] * nums[i] : nums[i] * nums[i];
            a = a>0 ? a+ nums[i] : nums[i];
            res = Math.max(res, Math.max(b,c));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}