package LeetCode;

import Method.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
class Solution_LC105 {
	private int now = 0;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
		// 将中序遍历的位置存入map
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(inorder[i], i);
		}
		return BuildTree(preorder,map,0,len-1);
	}
	public TreeNode BuildTree(int[] pre,Map<?,?> map,int left,int right){
		if(left > right)return null;
		int t = pre[now++];
		TreeNode temp = new TreeNode();
		// 找到当前前序遍历的值在中序遍历中的位置，中序遍历左边的值为树的左子树，右边的值为树的右子树
		int i = (int)map.get(t);
		temp.val = t;
		temp.left = BuildTree(pre,map,left,i-1);
		temp.right = BuildTree(pre,map,i+1,right);
		return temp;
	}
}
// 从前序与中序遍历序列构造二叉树
public class LC105 {
	public static void main (String [] args) {
		Solution_LC105 solution = new Solution_LC105();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode root = solution.buildTree(preorder,inorder);
		root.PrintAll(root);	// 输出结果 3 9 null null 20 15 null null 7 null null
	}
}