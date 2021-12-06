//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 758 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// java: 组合总和 II
// 2021-12-06 14:50:50
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis;
        int sum = 0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            vis = new boolean[candidates.length];
            Arrays.sort(candidates);
            dfs(0, target, candidates);
            return res;
        }
        public void dfs(int cur, int target, int[] nums) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = cur; i < nums.length; i++) {
                if (vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])) {
                    continue;
                }
                if (target -sum < nums[i]) {
                    break;
                }
                temp.add(nums[i]);
                vis[i] = true;
                sum += nums[i];
                dfs(i+1, target, nums);
                vis[i] = false;
                temp.remove(temp.size()-1);
                sum -= nums[i];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}