package LeetCode;

import Method.TreeNode;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */

class Solution_LC236 {
	// 1.其中一个节点是另一个节点的祖先
	// 2.两个节点在祖先节点的左右两侧
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return Check(root, p, q);
	}
	private TreeNode Check(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		TreeNode left = Check(root.left, p, q);
		TreeNode right = Check(root.right, p, q);
		// 当左右节点都不为空时，说明当前节点为两个节点的父节点
		if(left != null && right != null){
			return root;
		}
		// 当前节点等于 p 或者 q 时，返回当前节点
		if(root.val == p.val || root.val == q.val){
			return root;
		}
		// 其中一个节点为空或者两个都为空时返回一个节点
		return left != null ? left : right;


	}
}

// 二叉树的最近公共祖先
public class LC236 {
	public static void main (String [] args) {
		Solution_LC236 solution = new Solution_LC236 ();
		TreeNode root = new TreeNode();
		Integer[] res = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
		root = root.CreateTreeByCe(res);
		System.out.println (solution.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(1)).val);
		// 输出 3
	}
}