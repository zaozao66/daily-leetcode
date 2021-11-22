//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 👍 320 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// java: 字母大小写全排列
// 2021-11-19 16:13:58
public class P784LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new P784LetterCasePermutation().new Solution();
        solution.letterCasePermutation("");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<String> letterCasePermutation(String S) {
            char[] chs = S.toCharArray();
            List<String> res = new ArrayList<>();
            dfs(chs,0, res);
            return res;
        }
    public void dfs(char[] chars, int index, List<String> res) {
        res.add(String.valueOf(chars));
        for (int i = index; i < chars.length; i++) {
            if(Character.isLetter(chars[i])) {
                char tmp = chars[i];
                chars[i] = chars[i] = (char)(chars[i] - 'a' >= 0 ? chars[i] - 32 : chars[i] + 32);;
                dfs(chars, i+1, res);
                chars[i] = tmp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}