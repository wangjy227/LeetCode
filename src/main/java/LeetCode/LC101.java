package LeetCode;

import Method.TreeNode;

/**
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 */
class Solution_LC101 {
	public boolean isSymmetric(TreeNode root) {
		return Check(root.left, root.right);
	}
	public boolean Check(TreeNode left,TreeNode right){
		if(left == null && right == null){
			return true;
		}else if(left == null || right == null){
			return false;
		}else{
			if(left.val != right.val){
				return false;
			}else{
				return Check(left.left,right.right)&&Check(left.right,right.left);
			}
		}
	}
}
// 对称二叉树
public class LC101 {
	public static void main (String [] args) {
		Solution_LC101 solution = new Solution_LC101();
		TreeNode root = new TreeNode();
		Integer[] arr = new Integer[]{1,2,2,3,null,null,3};
		root = root.CreateTreeByCe(arr);
		System.out.println (solution.isSymmetric(root));	// 输出 true
	}
}