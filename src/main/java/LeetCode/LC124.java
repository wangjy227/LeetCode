package LeetCode;

import Method.TreeNode;

/**
 * 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * 提示：
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
class Solution {
	private int MAX = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		DFSPath(root);
		return MAX;
	}
	private int DFSPath(TreeNode treeNode){
		if(treeNode == null) return 0;
		// 分别记录左子树和右子树的最大路径值
		int left = DFSPath(treeNode.left);
		int right = DFSPath(treeNode.right);
		// 判断左右子树的值是否小于0
		left = Math.max(left,0);
		right = Math.max(right,0);
		// 1.当前节点和 左、右子树 构成最大路径和
		MAX = Math.max(MAX,treeNode.val+left+right);
		// 2.当前节点和 左子树 或者 右子树 或 自己单独 构成路径因素
		return treeNode.val+Math.max(left,right);
	}
}
// 二叉树中的最大路径和
public class LC124 {
	public static void main (String [] args) {
		Solution solution = new Solution ();
		TreeNode root = new TreeNode();
		Integer[] res = new Integer[]{-10,9,20,null,null,15,7};
		root = root.CreateTreeByCe(res);
		System.out.println (solution.maxPathSum(root));	// 输出 42
	}
}