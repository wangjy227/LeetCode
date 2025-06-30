package LeetCode;

import java.util.*;

/**
 * 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
class Solution_LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录课程的前修课程数
        int[] indegree = new int[numCourses];
        // 记录修该课程的后修课有哪些
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            indegree[prerequisites[i][0]]++;
            List<Integer> list = map2.getOrDefault(prerequisites[i][1],new ArrayList<>());
            list.add(prerequisites[i][0]);
            map2.put(prerequisites[i][1],list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < indegree.length;i++){
            if(indegree[i] <= 0){
                queue.add(i);
                numCourses--;
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> list = map2.get(cur);
            if(list != null){
                for(int i = 0;i < list.size();i++){
                    indegree[list.get(i)]--;
                    if(indegree[list.get(i)] == 0){
                        queue.add(list.get(i));
                        numCourses--;
                    }
                }
            }
        }
        return numCourses == 0;
    }
}

class Solution1_LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //定义入度数组，索引处（课程号）对应入度，比如课程0的入度为0
        int[] inDegree = new int[numCourses];
        //定义map数组，key课程号，value：依赖key的课程号，比如key为1，依赖的value为3，4
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length;i++){
            //遍历依赖关系表；在入度数组对应索引处++
            inDegree[prerequisites[i][0]]++;
            //没有对map初始化，这里对map初始化一个list数组，存放依赖的课程
            map.putIfAbsent(prerequisites[i][1],new ArrayList<>());
            //在对应被依赖课程key处添加依赖key的课程
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //新建列表，把入度为0的课放进来
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i <inDegree.length;i++){
            if(inDegree[i]==0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            //弹出已选课程，在map找到依赖它的课程，在入度数组--
            int course = que.poll();
            numCourses--;
            for(int nextCourse : map.getOrDefault(course,new ArrayList<>())){
                if(--inDegree[nextCourse]==0){
                    que.offer(nextCourse);
                }
            }
        }
        return numCourses==0;
    }
}
class Solution2_LC207 {
    // 通过课程先修课之间是否有环 来验证是否能选修
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录每个课程修完后可以修那些课程
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }
        // 染色法判断是否有环
        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) {
                return false; // 有环
            }
        }
        return true; // 没有环
    }

    // 返回 true 表示找到了环
    private boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1; // x 正在访问中
        for (int y : g[x]) {
            if (colors[y] == 1 || colors[y] == 0 && dfs(y, g, colors)) {
                return true; // 找到了环
            }
        }
        colors[x] = 2; // x 完全访问完毕
        return false; // 没有找到环
    }
}
// 课程表
public class LC207 {
    public static void main(String[] args) {
        Solution2_LC207 solution = new Solution2_LC207();
        int numCourses = 2;
        int[][] prerequisites = {};
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }
}