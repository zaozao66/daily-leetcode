# leetcode solutions in java
记录一下刷题的过程，不着急，慢慢来
贵在真实，贵在坚持

- [P21MergeTwoSortedLists合并两个有序链表](src/leetcode/editor/cn/P21MergeTwoSortedLists.java)

## 动态规划
- [P64MinimumPathSum最小路径和](src/leetcode/editor/cn/P64MinimumPathSum.java)（标准动态规划解决）
- [P221MaximalSquare最大正方形](src/leetcode/editor/cn/P221MaximalSquare.java)（状态转移方程找边长的关系而不是面积，第一次没做出来）
- [P5LongestPalindromicSubstring最长回文子串](src/leetcode/editor/cn/P5LongestPalindromicSubstring.java)（有更优的方法，但是可以先用基本的动态规划解决）
- [P516LongestPalindromicSubsequence最长回文子序列](src/leetcode/editor/cn/P516LongestPalindromicSubsequence.java)（没做出来，其实和上一题思路完全一样，换个形式不会做额典型）
- [P300LongestIncreasingSubsequence最长递增子序列](src/leetcode/editor/cn/P300LongestIncreasingSubsequence.java)（O(n2)的动态规划需要适应）
- [P376WiggleSubsequence摆动序列](src/leetcode/editor/cn/P376WiggleSubsequence.java)（与上题相同，但是场景更复杂一些 ）
- [P392IsSubsequence判断子序列](src/leetcode/editor/cn/P392IsSubsequence.java)（我以为是双指针的题，没想到这也可以动态规划，很有意思）
- [P1143LongestCommonSubsequence最长公共子序列](src/leetcode/editor/cn/P1143LongestCommonSubsequence.java)(已经感觉到有些套路但是第一遍还是没做出来)
- [P322CoinChange零钱兑换](src/leetcode/editor/cn/P322CoinChange.java)
- [P518CoinChange2零钱兑换 II](src/leetcode/editor/cn/P518CoinChange2.java)
- [P377CombinationSumIv组合总和 Ⅳ](src/leetcode/editor/cn/P377CombinationSumIv.java)
- [P343IntegerBreak整数拆分](src/leetcode/editor/cn/P343IntegerBreak.java)
- [P279PerfectSquares完全平方数](src/leetcode/editor/cn/P279PerfectSquares.java)
- [P487MaxConsecutiveOnesIi最大连续1的个数2](src/leetcode/editor/cn/P487MaxConsecutiveOnesIi.java)
- [P1035UncrossedLines不相交的线](src/leetcode/editor/cn/P1035UncrossedLines.java)（与1143最长公共子序列相同）

## 二分查找
二分查找永远需要注意细节
- [P153FindMinimumInRotatedSortedArray寻找旋转排序数组中的最小值](src/leetcode/editor/cn/P153FindMinimumInRotatedSortedArray.java)
- [P162FindPeakElement寻找峰值](src/leetcode/editor/cn/P162FindPeakElement.java)（这也能二分没想到，第一次没做出来）


## 双指针
- [P516LongestPalindromicSubsequence删除排序链表中的重复元素 II](src/leetcode/editor/cn/P516LongestPalindromicSubsequence.java)
- [P844BackspaceStringCompare比较含退格的字符串](src/leetcode/editor/cn/P844BackspaceStringCompare.java)（思路过于常规了，可以双指针做）
- [P986IntervalListIntersections区间列表的交集](src/leetcode/editor/cn/P986IntervalListIntersections.java)
- [P11ContainerWithMostWater盛最多水的容器](src/leetcode/editor/cn/P11ContainerWithMostWater.java)（这个题主要在证明）
- [P438FindAllAnagramsInAString找到字符串中所有字母异位词](P438FindAllAnagramsInAString)
- [P713SubarrayProductLessThanK乘积小于K的子数组](src/leetcode/editor/cn/P713SubarrayProductLessThanK.java)
- [P209MinimumSizeSubarraySum长度最小的子数组](src/leetcode/editor/cn/P209MinimumSizeSubarraySum.java)

## 深度/广度优先遍历
基本小规律，找符合要求的点dfs，找最xx的点用bfs
- [P200NumberOfIslands岛屿数量](src/leetcode/editor/cn/P200NumberOfIslands.java)
- [P117PopulatingNextRightPointersInEachNodeIi填充每个节点的下一个右侧节点指针 II](src/leetcode/editor/cn/P117PopulatingNextRightPointersInEachNodeIi.java)
- [P1091ShortestPathInBinaryMatrix二进制矩阵中的最短路径](src/leetcode/editor/cn/P1091ShortestPathInBinaryMatrix.java)
- [P130SurroundedRegions被围绕的区域](src/leetcode/editor/cn/P130SurroundedRegions.java)
- [P797AllPathsFromSourceToTarget所有可能的路径](src/leetcode/editor/cn/P797AllPathsFromSourceToTarget.java)
- [P265PaintHouseIi粉刷房子2](src/leetcode/editor/cn/P265PaintHouseIi.java)

## 递归/回溯
- [P78Subsets子集](src/leetcode/editor/cn/P78Subsets.java)
- [P90SubsetsIi子集2](src/leetcode/editor/cn/P90SubsetsIi.java)
- [P47PermutationsIi全排列2](src/leetcode/editor/cn/P47PermutationsIi.java)
- [P39CombinationSum组合总和](src/leetcode/editor/cn/P39CombinationSum.java)
