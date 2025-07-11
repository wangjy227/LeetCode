package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * 示例 1：
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 注意：x 是未定义的 => -1.0
 * 示例 2：
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * 提示：
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 */
class Solution_LC399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = values.length;
        Map<String, List<String>> nummap = new HashMap<>();
        for(int i = 0;i < len;i++){
            List<String> equation = equations.get(i);
            List<String> t = nummap.getOrDefault(equation.get(0), new ArrayList<>());
            t.add(equation.get(1));
            t.add(String.valueOf(values[i]));
            nummap.put(equation.get(0),t);
        }
        ArrayList<Double> ans = new ArrayList<>();
        for(List<String> querie: queries){
            String a = querie.get(0);
            String b = querie.get(1);
            ans.add(Cal(nummap,a,b,1));
        }
        double[] res = ans.stream().mapToDouble(Double::doubleValue).toArray();
        return res;
    }
    private double Cal(Map<String, List<String>> map,String a,String b,double x){
        if(map.get(a)==null && map.get(b)==null){
            return -1;
        }
        if(map.get(a)!=null){
            List<String> l = map.get(a);
            for(int i = 0;i < l.size();i+=2){
                x *= Double.valueOf(l.get(i+1));
                if(l.get(i).equals(b)){
                    return x;
                }
                return Cal(map,l.get(i),b,x);
            }
        }
        if(map.get(b)!=null){
            List<String> l = map.get(b);
            for(int i = 0;i < l.size();i+=2){
                x /= Double.valueOf(l.get(i+1));
                if(l.get(i).equals(a)){
                    return x;
                }
                return Cal(map,a,l.get(i),x);
            }
        }
        return -1;
    }
}

// 除法求值
public class AAA_LC399 {
    public static void main(String[] args) {
        Solution_LC399 solution = new Solution_LC399();
        String[][] equations1 = new String[][]{
                {"a", "e"},
                {"b", "e"},
        };
        List<List<String>> equations = Init(equations1);
        String[][] queries1 = new String[][]{
                {"a", "b"},
                {"e", "e"},
                {"a", "e"},
                {"a", "a"},
                {"x", "x"}
        };
        List<List<String>> queries = Init(queries1);

        double[] values = new double[]{4.0, 3.0};
        double[] newvalues = solution.calcEquation(equations, values, queries);
        for(int i = 0; i < newvalues.length; i++) {
            System.out.println(newvalues[i]);
        }
    }

    private static List<List<String>> Init(String[][] res) {
        List<List<String>> equations = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            List<String> equation = new ArrayList<>();
            for (int j = 0; j < res[0].length; j++) {
                equation.add(res[i][j]);
            }
            equations.add(equation);
        }
        return equations;
    }
}