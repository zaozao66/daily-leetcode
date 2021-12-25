//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2033 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

// java: 最长递增子序列
// 2021-11-26 09:20:33
public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(new int[]{4,10,4,3,8,9});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] arr = new int[nums.length];
            arr[0] = nums[0];
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > arr[len-1]) {
                    arr[len] = nums[i];
                    len++;
                } else {
                    int left = 0;
                    int right = len - 1;
                    while (left < right) {
                        int mid = (right -left) / 2 + left;
                        if (arr[mid] < nums[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    if (arr[right] > nums[i]) {
                        arr[right] = nums[i];
                    }
                }
            }
            return len;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}