//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2864 👎 0

package leetcode.editor.cn;
// java: 接雨水
public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int trap(int[] height) {
            int left = 0;
            int leftMax = height[left];
            int right = height.length -1;
            int rightMax = height[right];
            int res = 0;
            while (left < right) {
                if (leftMax < rightMax) {
                    res += leftMax - height[left];
                    left++;
                    leftMax=Math.max(leftMax, height[left]);
                } else {
                    res += rightMax - height[right];
                    right--;
                    rightMax=Math.max(rightMax, height[right]);
                }
            }
            return res;
        }

        public int trap1(int[] height) {
            if (height.length == 1) {
                return 0;
            }
            int[] leftMax = new int[height.length];
            leftMax[0] = 0;
            int[] rightMax = new int[height.length];
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
            }
            rightMax[height.length-1] = 0;
            for (int i = height.length-2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
            }
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                if (leftMax[i] > height[i] && rightMax[i]>height[i]) {
                    result += Math.min(leftMax[i], rightMax[i]) - height[i];
                }
            }
            return result;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}