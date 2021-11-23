//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1306 👎 0

package leetcode.editor.cn;
// java: 在排序数组中查找元素的第一个和最后一个位置
// 2021-11-23 09:33:48
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[] {-1,-1};
            }
            int left = 0;
            int right = nums.length -1;
            int mid;
            while (left < right) {
                mid = (left+right)/2;
                if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target){
                    left = mid + 1;
                } else {
                    right = mid;
                    break;
                }
            }
            if (nums[right] == target) {
                return new int[]{findLeft(nums, target, 0, right), findRight(nums, target, right, nums.length-1)};
            } else {
                return new int[]{-1,-1};
            }
        }

        public int findLeft(int[] nums, int target, int left, int right) {
            int mid;
            while (left < right) {
                mid = (left+right)/2;
                if (nums[mid] == target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }

        public int findRight(int[] nums, int target, int left, int right) {
            int mid;
            while (left < right) {
                mid = (left+right)/2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[right] == target ? right :right-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}