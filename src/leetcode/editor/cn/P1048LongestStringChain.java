//给出一个单词列表，其中每个单词都由小写英文字母组成。 
//
// 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 
//"abac" 的前身。 
//
// 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_
//2 是 word_3 的前身，依此类推。 
//
// 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。 
// 
//
// 示例： 
//
// 输入：["a","b","ba","bca","bda","bdca"]
//输出：4
//解释：最长单词链之一为 "a","ba","bda","bdca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] 仅由小写英文字母组成。 
// 
//
// 
// Related Topics 数组 哈希表 双指针 字符串 动态规划 👍 146 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

// java: 最长字符串链
// 2021-12-08 21:29:50
public class P1048LongestStringChain {
    public static void main(String[] args) {
        Solution solution = new P1048LongestStringChain().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        int res = 0;
        int idx = 0;
        int jdx = -1;
        int ilength = -1;
        int jlength = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != ilength) {
                jlength = ilength;
                jdx = idx;
                idx = i;
                ilength = words[i].length();
            }
            dp[i] = 1;
            for (int j = jdx; j < idx; j++) {
                if (isSubWord(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public boolean isSubWord(String word1, String word2) {
        if (word1.length() != word2.length()-1) {
            return false;
        }
        boolean flag = false;
        int i = 0, j = 0;
        while (i < word1.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                if (flag) {
                    return false;
                }
                flag = true;
            } else {
                i++;
            }
            j++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}