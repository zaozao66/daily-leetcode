//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4376 👎 0

package leetcode.editor.cn;
// java: 最长回文子串
// 2021-11-25 09:25:33
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
        }
        int j, maxLen = 1, begin= 0;
        for (int len = 2; len <= m; len++) {
            for (int i = 0; i < m; i++) {
                j = i + len -1;
                if (j > m -1) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (len < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                }

                if (dp[i][j] && len > maxLen) {
                    begin = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}