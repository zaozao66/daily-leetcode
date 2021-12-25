//现有一个按 升序 排列的整数数组 nums ，其中每个数字都 互不相同 。 
//
// 给你一个整数 k ，请你找出并返回从数组最左边开始的第 k 个缺失数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,7,9,10], k = 1
//输出：5
//解释：第一个缺失数字为 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,7,9,10], k = 3
//输出：8
//解释：缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,4], k = 3
//输出：6
//解释：缺失数字有 [3,5,6,7,...]，因此第三个缺失数字为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 1 <= nums[i] <= 10⁷ 
// nums 按 升序 排列，其中所有元素 互不相同 。 
// 1 <= k <= 10⁸ 
// 
//
// 
//
// 进阶：你可以设计一个对数时间复杂度（即，O(log(n))）的解决方案吗？ 
// Related Topics 数组 二分查找 👍 92 👎 0

package leetcode.editor.cn;
// java: 有序数组中的缺失元素
// 2021-12-14 11:47:38
public class P1060MissingElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P1060MissingElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingElement(int[] nums, int k) {
            int left = 0;
            int right = nums.length - 1;
            int mid;
            while (left < right) {
                mid = (right - left + 1)/2+left;
                if (getNum(nums,mid) < k) {
                    left = mid;
                } else {
                    right = mid-1;
                }
            }
            int num = getNum(nums, left);
            return nums[left]+k-num;
        }

        public int getNum(int[] nums, int k) {
            return nums[k] - nums[0] -k;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}