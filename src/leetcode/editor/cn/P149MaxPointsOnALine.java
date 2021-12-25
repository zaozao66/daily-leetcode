//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// points 中的所有点 互不相同 
// 
// Related Topics 几何 哈希表 数学 👍 362 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// java: 直线上最多的点数
// 2021-12-13 09:33:18
public class P149MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new P149MaxPointsOnALine().new Solution();
        int i = solution.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1 || points.length ==2) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    if (dx == 0) {
                        dy = 1;
                    } else if (dy == 0) {
                        dx = 1;
                    } else {
                        if (dy < 0) {
                            dx = -dx;
                            dy = -dy;
                        }
                        int gcdXY = gcd(dx, dy);
                        dx = dx/gcdXY;
                        dy = dy/gcdXY;
                    }
                    String key = dx + "|" + dy;
                    int value = map.getOrDefault(key, 1) + 1;
                    map.put(key, value);
                    max = Math.max(value, max);
                }
            }
        }
        return max;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}