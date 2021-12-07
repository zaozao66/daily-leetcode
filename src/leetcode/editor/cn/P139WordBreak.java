//给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。 
//
// 说明：拆分时可以重复使用字典中的单词。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1284 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// java: 单词拆分
// 2021-12-07 09:42:39
public class P139WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int max = 0;
        for (String s1 : wordDict) {
            set.add(s1);
            max = Math.max(max, s1.length());
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j >= 0 && j>=i-max; j--) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}