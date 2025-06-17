package LeetCode;

import Method.TreeNode;

/**
 * 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
class Solution_LC114 {
	public void flatten(TreeNode root) {
		Root = new TreeNode();
		MyFlatten(root);
		ChangeRight(root);
	}
	private TreeNode Root;
	// 将所有节点移到二叉树的左边
	private void MyFlatten(TreeNode root) {
		if(root == null) return;
		Root.left = root;
		Root = Root.left;
		MyFlatten(root.left);
		MyFlatten(root.right);
		root.right = null;
	}
	// 将二叉树所有左边节点移到二叉树的右边
	private void ChangeRight(TreeNode root) {
		if(root == null) return;
		root.right = root.left;
		root.left = null;
		ChangeRight(root.right);
	}
}

// 二叉树展开为链表
public class LC114 {
	public static void main (String [] args) {
		Solution_LC114 solution = new Solution_LC114();
		TreeNode root = new TreeNode();
		Integer[] arr=  new Integer[]{1,2,5,3,4,null,6};
		root = root.CreateTreeByCe(arr);
		solution.flatten(root);
		root.PrintAll(root);
		// 输出结果 1 null 2 null 3 null 4 null 5 null 6 null null
	}
}