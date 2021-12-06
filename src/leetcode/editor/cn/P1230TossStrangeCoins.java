//有一些不规则的硬币。在这些硬币中，prob[i] 表示第 i 枚硬币正面朝上的概率。 
//
// 请对每一枚硬币抛掷 一次，然后返回正面朝上的硬币数等于 target 的概率。 
//
// 
//
// 示例 1： 
//
// 输入：prob = [0.4], target = 1
//输出：0.40000
// 
//
// 示例 2： 
//
// 输入：prob = [0.5,0.5,0.5,0.5,0.5], target = 0
//输出：0.03125
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prob.length <= 1000 
// 0 <= prob[i] <= 1 
// 0 <= target <= prob.length 
// 如果答案与标准答案的误差在 10^-5 内，则被视为正确答案。 
// 
// Related Topics 数学 动态规划 概率与统计 👍 41 👎 0

package leetcode.editor.cn;
// java: 抛掷硬币
// 2021-12-06 09:47:59
public class P1230TossStrangeCoins {
    public static void main(String[] args) {
        Solution solution = new P1230TossStrangeCoins().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] res = new double[prob.length+1];
        res[0] = 1;
        for (int i = 0; i < prob.length; i++) {
            for (int j = i+1; j > 0; j--) {
                res[j] = res[j] * (1-prob[i]) + res[j-1] * prob[i];
            }
            res[0] = res[0] * (1-prob[i]);
        }
        return res[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}