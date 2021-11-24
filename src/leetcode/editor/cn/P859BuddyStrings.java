//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 10⁴ 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 👍 203 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

// java: 亲密字符串
// 2021-11-23 11:25:34
public class P859BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new P859BuddyStrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        boolean isRepeat = false;
        char s1 = ' ', g1 = ' ';
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
                if (count ==1) {
                    s1 = s.charAt(i);
                    g1 = goal.charAt(i);
                }
                if (count == 2) {
                    if (s1 != goal.charAt(i) || g1 != s.charAt(i)) {
                        return false;
                    }
                }
            } else {
                if (count == 0 && !isRepeat) {
                    if (set.contains(s.charAt(i))) {
                        isRepeat = true;
                    } else {
                        set.add(s.charAt(i));
                    }
                }
            }
        }
        return (count == 0 && isRepeat) || count==2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}