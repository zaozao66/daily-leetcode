//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 10⁹ 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 数学 动态规划 排序 👍 413 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// java: 最大整除子集
// 2021-12-09 11:42:08
public class P368LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new P368LargestDivisibleSubset().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List[] dp = new ArrayList[nums.length];
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new ArrayList();
            dp[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i].size() < dp[j].size() +1) {
                        dp[i] = new ArrayList(dp[j]);
                        dp[i].add(nums[i]);
                    }
                }
            }
            if (res.size() < dp[i].size()) {
                res = new ArrayList<Integer>(dp[i]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}