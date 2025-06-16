package LeetCode;

import Method.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * [3,9,20,15,7]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * 提示:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */

class Solution_LC106 {
	private int now;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int len = inorder.length;
		now = len - 1;
		// 将中序遍历的序列位置存入 map 数组
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return BuildTree(postorder,map,0,len-1);
	}
	private TreeNode BuildTree(int[] pos,Map<Integer,Integer> map,int left,int right){
		if(now<0||left > right) return null;
		int t = pos[now--];
		// 根据后序遍历的值找到在中序遍历中的位置，左->左子树 右->右子树
		int idx = map.get(t);
		TreeNode root = new TreeNode(t);
		root.right = BuildTree(pos,map,idx+1,right);
		root.left = BuildTree(pos,map,left,idx-1);
		return root;
	}
}
// 从中序与后序遍历序列构造二叉树
public class LC106 {
	public static void main (String [] args) {
		Solution_LC106 solution = new Solution_LC106();
		int[] postorder = {9,15,7,20,3};
		int[] inorder = {9,3,15,20,7};
		TreeNode root = solution.buildTree(inorder,postorder);
		root.PrintAll(root);	// 输出结果 3 9 null null 20 15 null null 7 null null
	}
}