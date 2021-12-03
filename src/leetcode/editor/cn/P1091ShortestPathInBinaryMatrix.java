//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 142 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// java: 二进制矩阵中的最短路径
// 2021-12-01 22:47:17
public class P1091ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new P1091ShortestPathInBinaryMatrix().new Solution();
        solution.shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,1,0}, {1,1,0}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] pos = new int[][]{
                new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0,-1},
                new int[]{1,1}, new int[]{1,-1}, new int[]{-1,1}, new int[]{-1,-1}
        };

        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] ==1) {
                return -1;
            }
            if (grid.length == 1) {
                return 1;
            }
            grid[0][0] = 1;
            Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{0, 0});
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    int[] p = deque.pollFirst();
                    for (int[] po : pos) {
                        int x = p[0] + po[0];
                        int y = p[1] + po[1];
                        if (x<0 || x> grid.length-1 || y < 0 || y>grid[0].length-1) {
                            continue;
                        }
                        if (grid[x][y] ==0) {
                            grid[x][y] = grid[p[0]][p[1]] + 1;
                            if (x==grid.length-1&& y==grid[0].length-1) {
                                return grid[x][y];
                            }
                            deque.offer(new int[]{x,y});
                        }
                    }
                }
            }
            return -1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}