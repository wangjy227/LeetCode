package LeetCode;

import Method.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * 提示：
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * 				30
 * 		15				50
 * 	7		29		33
 *
 * 	1
 */
class Solution_LC530 {
	int pre;
	int ans;
	public int getMinimumDifference(TreeNode root) {
		ans = Integer.MAX_VALUE;
		pre = -1;
		dfs(root);
		return ans;
	}
	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		// 中序遍历，二叉搜索树中左子树节点值小于父节点，右子树节点值大于父节点
		// 通过中序遍历 用当前节点的值减去前一个节点的值
		dfs(root.left);
		if (pre == -1) {
			pre = root.val;
		} else {
			ans = Math.min(ans, root.val - pre);
			pre = root.val;
		}
		dfs(root.right);
	}
}
// 二叉搜索树的最小绝对差
public class LC530 {
	public static void main (String [] args) {
		Solution_LC530 solution = new Solution_LC530 ();
		TreeNode root = new TreeNode();
		Integer[] res = new Integer[]{236,104,701,null,227,null,911};
		root = root.CreateTreeByCe(res);
		System.out.println (solution.getMinimumDifference(root));
		// 输出 9
	}
}