//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1642 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// java: 全排列
// 2021-11-19 15:02:29
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        solution.permute(new int[]{1,2,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] flag = new boolean[nums.length];
        dfs(nums, flag, deque, res);
        return res;
    }
    
    public void dfs(int[] nums, boolean[] flag, Deque<Integer> deque, List<List<Integer>> res) {
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                deque.add(nums[i]);
                flag[i] = true;
                dfs(nums, flag,deque, res);
                deque.removeLast();
                flag[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}