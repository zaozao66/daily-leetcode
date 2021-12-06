//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1658 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// java: 组合总和
// 2021-12-06 14:21:47
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        solution.combinationSum(new int[]{2,3,6,7}, 7);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(0, candidates, target);
            return res;
        }

        public void dfs(int cur, int[] nums, int target) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                res.add(new ArrayList<>(temp));
            }
            for (int i = cur; i < nums.length; i++) {
                if (target - sum < nums[i]) {
                    break;
                }
                temp.add(nums[i]);
                sum += nums[i];
                dfs(i, nums, target);
                sum -= nums[i];
                temp.remove(temp.size()-1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}