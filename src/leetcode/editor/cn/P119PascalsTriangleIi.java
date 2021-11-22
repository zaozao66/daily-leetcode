//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 👍 336 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// java: 杨辉三角 II
// 2021-11-22 14:48:51
public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        int[] row1 = new int[rowIndex];
        int[] row2;

        row1[0] = 1;
        row2 = row1.clone();
        for (int i = 1; i < rowIndex; i++) {
            row1[0] = 1;
            for (int j = 1; j < i; j++) {
                row1[j] = row2[j] + row2[j-1];
            }
            row1[i] = 1;
            row2 = row1.clone();
        }
        return Arrays.stream(row1,0,rowIndex).boxed().collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}