//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4013 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// java: 三数之和
// 2021-11-25 11:25:19
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        solution.threeSum(new int[]{1,-1,1,0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int m = nums.length;
        for (int i = 0; i < m; i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i +1;
            int right = m -1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while (left < m-1 && nums[left+1] == nums[left]) { left++; }
                    while (right-1 > i && nums[right-1] == nums[right]) { right--; }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else {
                    left++;
                }

            }
            while (i+1<m && nums[i]==nums[i+1]){i++;}
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}