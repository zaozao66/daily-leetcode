//力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。 
//
// 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。 
//
// 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器
//。 
//
// 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。 
//
// 请你以任意顺序返回该集群内的所有 「关键连接」。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//输出：[[1,3]]
//解释：[[3,1]] 也是正确的。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// n-1 <= connections.length <= 10^5 
// connections[i][0] != connections[i][1] 
// 不存在重复的连接 
// 
// Related Topics 深度优先搜索 图 双连通分量 👍 165 👎 0

package leetcode.editor.cn;

import java.util.*;

// java: 查找集群内的「关键连接」
// 2021-11-18 18:10:51
public class P1192CriticalConnectionsInANetwork {
    public static void main(String[] args) {
        Solution solution = new P1192CriticalConnectionsInANetwork().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildMap(connections, map);

        int[] id = new int[n];
        Arrays.fill(id, -1);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,0,-1,id, map, res);
        return res;
    }

    public int dfs(int node, int nodeId, int parent, int[] id, Map<Integer, Set<Integer>> map, List<List<Integer>> res) {
        id[node] = nodeId;
        Set<Integer> integers = map.get(node);
        for (Integer integer : integers) {
            if (integer == parent) {
            } else if(id[integer] == -1){
                id[node] = Math.min(id[node], dfs(integer, nodeId+1, node, id,map,res));
            } else {
                id[node] = Math.min(id[node], id[integer]);
            }
        }
        if (id[node] == nodeId && node != 0) {
            res.add(Arrays.asList(node, parent));
        }
        return id[node];
    }

    public void buildMap(List<List<Integer>> connections, Map<Integer, Set<Integer>> map) {
        for (List<Integer> connection : connections) {
            Integer i1 = connection.get(0);
            Integer i2 = connection.get(1);

            Set<Integer> i1set = map.getOrDefault(i1, new HashSet<>());
            Set<Integer> i2set = map.getOrDefault(i2, new HashSet<>());

            i1set.add(i2);
            i2set.add(i1);

            map.put(i1, i1set);
            map.put(i2, i2set);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}