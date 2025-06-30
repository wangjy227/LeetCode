package LeetCode;

import java.util.*;

/**
 * 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 */
class Solution_LC210 {
	private List<Integer> res = new ArrayList<>();
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// 记录修完当前课程后可以修哪些课程
		List<Integer>[] graph = new ArrayList[numCourses];
		Arrays.setAll(graph, i -> new ArrayList<>());
		// 记录每个课程的先修课数量
		int[] indegree = new int[numCourses];
		for(int i = 0;i < prerequisites.length;i++){
			indegree[prerequisites[i][0]]++;
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0;i < numCourses;i++){
			if(indegree[i] == 0){
				queue.add(i);
				res.add(i);
			}
		}
		bfs(queue, graph, indegree);
		if(res.size() == numCourses){
			return res.stream().mapToInt(i->i).toArray();
		}else{
			return new int[0];
		}
	}
	private void bfs(Queue<Integer> queue, List<Integer>[] graph, int[] indegree) {
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next : graph[cur]) {
				if(--indegree[next] == 0) {
					queue.add(next);
					res.add(next);
				}
			}
		}
	}
}

class Solution1_LC210 {
	private List<List<Integer>> edges=new ArrayList<>();
	private boolean valid=true;
	private int[] result;
	private int index;
	private int[] status;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		result=new int[numCourses];
		status=new int[numCourses];
		index=numCourses-1;
		for(int i=0;i<numCourses;i++){
			edges.add(new ArrayList<Integer>());
		}
		for(int[] info:prerequisites){
			edges.get(info[1]).add(info[0]);
		}
		for(int i=0;i<numCourses;i++){
			if(status[i]==0){
				dfs(i);
				if(!valid){
					return new int[0];
				}
			}
		}
		return result;
	}
	private void dfs(int i){
		status[i]=1;
		List<Integer> sides=edges.get(i);
		for(int v:sides){
			if(status[v]==1){
				valid=false;
				return;
			}
			else if(status[v]==0){
				dfs(v);
				if(!valid){
					return;
				}
			}
		}
		status[i]=2;
		result[index--]=i;
	}
}

// 课程表 II
public class LC210 {
	public static void main(String[] args) {
		Solution_LC210 solution = new Solution_LC210();
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));
	}
}