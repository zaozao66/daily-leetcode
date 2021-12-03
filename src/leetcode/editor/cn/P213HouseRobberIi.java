//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 848 👎 0

package leetcode.editor.cn;
// java: 打家劫舍 II
// 2021-12-01 11:42:43
public class P213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new P213HouseRobberIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums.length ==1) {
            return nums[0];
        }
        if (nums.length ==2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3)  {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int a = nums[0], b= nums[1], c = nums[0]+nums[2], temp;
        int a1 = nums[1], b1 = nums[2], c1= a1 + nums[3], temp1;
        for (int i = 3; i < nums.length - 1; i++) {
            temp = Math.max(a, b) +nums[i];
            a=b;
            b=c;
            c=temp;
            temp1 = Math.max(a1,b1) + nums[i+1];
            a1=b1;
            b1=c1;
            c1=temp1;
        }
        return Math.max(Math.max(b,c), Math.max(b1, c1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}