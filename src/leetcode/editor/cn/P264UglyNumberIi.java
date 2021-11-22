//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 780 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

// java: 丑数 II
// 2021-11-19 09:51:52
public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 略加思考，动态规划解决
         * @param n
         * @return
         */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i =0, j = 0, k = 0;
        dp[0]=1;
        for (int l = 1; l < n; l++) {
            dp[l] = Math.min(2*dp[i], Math.min(3*dp[j], 5*dp[k]));
            if (2*dp[i] == dp[l]) {
                i++;
            }
            if (3*dp[j] == dp[l]) {
                j++;
            }
            if (5*dp[k] == dp[l]) {
                k++;
            }
        }
        return dp[n-1];
    }
        /**
         * 遍历超时
         * @param n
         * @return
         */
    public int nthUglyNumberTimeOut(int n) {
        if (n == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int count = 1;
        int i = 2;
        while (count <=n) {
            if ((i%2 ==0 && set.contains(i/2)) || (i%3 ==0 && set.contains(i/3)) || (i%5 ==0 && set.contains(i/5))) {
                count++;
                if(count==n) {
                    return i;
                } else {
                    set.add(i);
                }
            }
            i++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}