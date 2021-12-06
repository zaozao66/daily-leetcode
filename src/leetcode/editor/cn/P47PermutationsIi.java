//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 883 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// java: 全排列 II
// 2021-12-06 13:35:00
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] seen;
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            seen = new boolean[nums.length];
            dfs(0, nums);
            return res;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (seen[i] || (i > 0 && nums[i] == nums[i-1] && !seen[i-1])) {
                    continue;
                }
                temp.add(nums[i]);
                seen[i] = true;
                dfs(cur+1, nums);
                seen[i] = false;
                temp.remove(cur);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}