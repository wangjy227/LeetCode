package LeetCode;

import Method.TreeNode;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
class Solution_LC230 {
	private int num;
	// 用 k 记录当前是第几小的值
	private int k;
	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		KTH(root);
		return num;
	}
	private void KTH(TreeNode root) {
		if(root == null) return;
		KTH(root.left);
		k--;
		// 当 k 等于 0 时，当前值为第 k 小的值
		if(k == 0) {
			num = root.val;
			k = -1;
		}
		if(k <= -1) return;
		KTH(root.right);
	}
}
// 二叉搜索树中第K小的元素
public class LC230 {
	public static void main (String [] args) {
		Solution_LC230 solution = new Solution_LC230();
		TreeNode root = new TreeNode();
		Integer[] arr = new Integer[]{5,3,6,2,4,null,null,1};
		root = root.CreateTreeByCe(arr);
		System.out.println (solution.kthSmallest(root, 3));
		// 输出 3
	}
}