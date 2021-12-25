//对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。 
//
// 给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造
//目标字符串，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：source = "abc", target = "abcbc"
//输出：2
//解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
// 
//
// 示例 2： 
//
// 输入：source = "abc", target = "acdbc"
//输出：-1
//解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
// 
//
// 示例 3： 
//
// 输入：source = "xyz", target = "xzyxz"
//输出：3
//解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
// 
//
// 
//
// 提示： 
//
// 
// source 和 target 两个字符串都只包含 "a"-"z" 的英文小写字母。 
// source 和 target 两个字符串的长度介于 1 和 1000 之间。 
// 
// Related Topics 贪心 字符串 动态规划 👍 69 👎 0

package leetcode.editor.cn;
// java: 形成字符串的最短路径
// 2021-12-13 11:28:01
public class P1055ShortestWayToFormString {
    public static void main(String[] args) {
        Solution solution = new P1055ShortestWayToFormString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestWay(String source, String target) {
        int res = 1;
        int pos = -1;
        for (int i = 0; i < target.length(); i++) {
            int oriPos = pos;
            int oriRes = res;
            for (int j = pos+1; j < source.length(); j++) {
                if (source.charAt(j)==target.charAt(i)) {
                    pos=j;
                    break;
                }
            }
            if (oriPos == pos) {
                for (int j = 0; j < pos + 1; j++) {
                    if (source.charAt(j) == target.charAt(i)) {
                        res++;
                        pos =j;
                        break;
                    }
                }
            }
            if (oriPos == pos && res == oriRes) {
                return -1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}