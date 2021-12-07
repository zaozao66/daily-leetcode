//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2195 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// java: 括号生成
// 2021-12-06 22:20:35
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<String> generateParenthesis(int n){
            List<String> res = new ArrayList<>();
            dfs(n, "", res, 0,0);
            return res;
        }

        public void dfs(int n, String path, List<String> res, int left, int right) {
            if (path.length() == 2 * n) {
                res.add(path);
                return;
            }
            if (left < n) {
                dfs(n, path+"(", res, left+1, right);
            }
            if (right < left) {
                dfs(n, path+")", res, left, right+1);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}