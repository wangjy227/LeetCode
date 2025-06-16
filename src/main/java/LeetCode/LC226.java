package LeetCode;

import Method.TreeNode;

/**
 * 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
class Solution_LC226 {
	public TreeNode invertTree(TreeNode root) {
		inorderTraversal(root);
		return root;
	}
	public void inorderTraversal(TreeNode root) {
		if (root == null) return;
		TreeNode T = root.left;
		root.left = root.right;
		root.right = T;
		inorderTraversal(root.left);
		inorderTraversal(root.right);
	}
}
// 翻转二叉树
public class LC226 {
	public static void main (String [] args) {
		Solution_LC226 solution = new Solution_LC226();
		TreeNode root = new TreeNode();
		Integer[] arr = new Integer[]{1,2,3,4,null,5,null};
		//         1
		//      2     3
		//   4     5
		root = root.CreateTreeByCe(arr);
		root = solution.invertTree(root);
		root.PrintAll(root);
		// 输出 1 3 null 5 null null 2 null 4 null null
		//             1
		//         3        2
		//            5         4
	}
}