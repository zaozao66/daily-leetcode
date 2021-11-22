//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁶ <= nums[i] <= 10⁶ 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 10⁴ 次 reset 和 shuffle 
// 
// Related Topics 数组 数学 随机化 👍 219 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

// java: 打乱数组
// 2021-11-22 17:42:25
public class P384ShuffleAnArray {
    public static void main(String[] args) {
        Solution solution = new P384ShuffleAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] nums;
        int[] random;
        public Solution() {}

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = nums.clone();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            handleRandom();
            return random;

        }
        public void handleRandom() {
            for (int i = 0; i < nums.length; i++) {
                int index = new Random().nextInt(nums.length-1);
                int temp = random[i];
                random[i] = random[index];
                random[index] = temp;
            }
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}