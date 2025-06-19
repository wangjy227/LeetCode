package LeetCode;

import Method.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * 示例 2:
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 提示：
 * 树中节点数量在 [1, 104] 范围内
 * -231 <= Node.val <= 231 - 1
 */
class Array_LC637{
	long sum;
	long num;
	Array_LC637(){sum = 0;num = 0;}

	public Array_LC637(int _sum, int _num) {
		sum = _sum;
		num = _num;
	}
}
class Solution_LC637 {
	public Map<Integer, Array_LC637> map = new HashMap<>();
	public List<Double> averageOfLevels(TreeNode root) {
		Caculate(root, 1);
		List<Double> result = new ArrayList<>();
		for(Array_LC637 a: map.values()){
			result.add(a.sum*1.0/a.num);
		}
		return result;
	}
	public void Caculate(TreeNode root,int now) {
		if(root == null){
			return;
		}
		Array_LC637 t = map.getOrDefault(now,new Array_LC637());
		t.sum += root.val;
		t.num++;
		map.put(now,t);
		Caculate(root.left,now+1);
		Caculate(root.right,now+1);
	}
}
// 二叉树的层平均值
public class LC637 {
	public static void main (String [] args) {
		Solution_LC637 solution = new Solution_LC637 ();
		TreeNode root = new TreeNode();
		Integer[] res = new Integer[]{3,9,20,null,null,15,7};
		root = root.CreateTreeByCe(res);
		System.out.println (solution.averageOfLevels(root));
		// 输出 [3.0, 14.5, 11.0]
	}
}