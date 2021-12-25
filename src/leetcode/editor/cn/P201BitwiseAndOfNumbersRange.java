//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
// Related Topics 位运算 👍 345 👎 0

package leetcode.editor.cn;

import java.util.Random;

// java: 数字范围按位与
// 2021-12-12 09:15:04
public class P201BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new P201BitwiseAndOfNumbersRange().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & right - 1;
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}