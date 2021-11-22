//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 630 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// java: 杨辉三角
// 2021-11-22 14:18:40
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        solution.generate(5);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[] row1 = new int[numRows];
        int[] row2 = new int[numRows];

        row1[0] = 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> collect = Arrays.stream(row1,0,1).boxed().collect(Collectors.toList());
        res.add(collect);
        row2 = row1.clone();
        for (int i = 1; i < numRows; i++) {
            row1[0] = 1;
            for (int j = 1; j < i; j++) {
                row1[j] = row2[j] + row2[j-1];
            }
            row1[i] = 1;
            List<Integer> collectRow = Arrays.stream(row1,0,i+1).boxed().collect(Collectors.toList());
            row2 = row1.clone();
            res.add(collectRow);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}