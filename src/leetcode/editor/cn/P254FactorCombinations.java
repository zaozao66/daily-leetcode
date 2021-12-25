//整数可以被看作是其因子的乘积。 
//
// 例如： 
//
// 8 = 2 x 2 x 2;
//  = 2 x 4. 
//
// 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。 
//
// 注意： 
//
// 
// 你可以假定 n 为永远为正数。 
// 因子必须大于 1 并且小于 n。 
// 
//
// 示例 1： 
//
// 输入: 1
//输出: []
// 
//
// 示例 2： 
//
// 输入: 37
//输出: [] 
//
// 示例 3： 
//
// 输入: 12
//输出:
//[
//  [2, 6],
//  [2, 2, 3],
//  [3, 4]
//] 
//
// 示例 4: 
//
// 输入: 32
//输出:
//[
//  [2, 16],
//  [2, 2, 8],
//  [2, 2, 2, 4],
//  [2, 2, 2, 2, 2],
//  [2, 4, 4],
//  [4, 8]
//]
// 
// Related Topics 数组 回溯 👍 100 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// java: 因子的组合
// 2021-12-14 09:54:22
public class P254FactorCombinations {
    public static void main(String[] args) {
        Solution solution = new P254FactorCombinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> set = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        public List<List<Integer>> getFactors(int n) {

            for (int i = 2; i <= n/2; i++) {
                if (n % i == 0) {
                    set.add(i);
                }
            }
            if (set.isEmpty()) {
                return res;
            }
            dfs(n, 0);
            return res;
        }

        public void dfs(int n, int index) {
            if (n == 1) {
                res.add(new ArrayList<>(temp));
            }
            for (int i = index; i<set.size(); i++) {
                 if (n % set.get(i) ==0) {
                    temp.add(set.get(i));
                    dfs(n/set.get(i), i);
                    temp.remove(temp.size()-1);
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}