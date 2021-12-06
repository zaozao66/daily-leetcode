//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1634 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// java: 电话号码的字母组合
// 2021-12-06 16:03:45
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String[]> map = new HashMap<>();
        String[] temp;
        List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if(digits.length() == 0) {
                return new ArrayList<>();
            }
            map.put('2', new String[]{"a", "b", "c"});
            map.put('3', new String[]{"d", "e", "f"});
            map.put('4', new String[]{"g","h","i"});
            map.put('5', new String[]{"j","k","l"});
            map.put('6', new String[]{"m", "n","o"});
            map.put('7', new String[]{"p", "q", "r","s"});
            map.put('8', new String[]{"t", "u", "v"});
            map.put('9', new String[]{"w", "x", "y", "z"});
            temp = new String[digits.length()];
            dfs(0, digits);
            return res;
        }

        public void dfs(int cur, String digits) {
            if (cur == digits.length()) {
                res.add(String.join("", temp));
                return;
            }
            for (int i = 0; i < map.get(digits.charAt(cur)).length; i++) {
                temp[cur] = map.get(digits.charAt(cur))[i];
                dfs(cur+1, digits);
                temp[cur] = "";
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}