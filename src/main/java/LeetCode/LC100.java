package LeetCode;

import Method.TreeNode;

/**
 * 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
class Solution_LC100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if((p == null&& q!= null) || (p!=null&&q == null)) return false;
		if(p.val != q.val){
			return false;
		}else{
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}
// 相同的树
public class LC100 {
	public static void main (String [] args) {
		Solution_LC100 solution = new Solution_LC100();
		TreeNode root1 = new TreeNode();
		TreeNode root2 = new TreeNode();
		Integer[] arr1 = new Integer[]{1,2,3};
		Integer[] arr2 = new Integer[]{1,2,3};
		root1 = root1.CreateTreeByCe(arr1);
		root2 = root2.CreateTreeByCe(arr2);
		System.out.println (solution.isSameTree(root1, root2));	// 输出 true
	}
}