package LeetCode;

import Method.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */

/**
 * class Solution {
 * 	private List<List<Integer>> res = new ArrayList<>();
 * 	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
 * 		if(root == null) return res;
 * 		Queue<TreeNode> queue = new LinkedList<>();
 * 		queue.add(root);
 * 		ZIGZAG(queue,1,false);
 * 		return res;
 * 	    }
 * 	private void ZIGZAG(Queue<TreeNode> que, int len,boolean Check) {
 * 		if(que.isEmpty()){
 * 			return;
 *        }
 * 		int sum = 0;
 * 		List<Integer> list = new ArrayList<>();
 * 		for(int i = 0;i < len;i++){
 * 			TreeNode node = que.poll();
 * 			list.add(node.val);
 * 			if(node.left != null){
 * 				que.offer(node.left);
 * 				sum++;
 *            }
 * 			if(node.right != null){
 * 				que.offer(node.right);
 * 				sum++;
 *            }
 *        }
 * 		if(Check){
 * 			Check = false;
 * 			// 相反方向遍历
 * 			Collections.reverse(list);
 *        }else{
 * 			Check = true;
 *        }
 * 		res.add(list);
 * 		ZIGZAG(que,sum,Check);
 *    }
 * }
 */

class Solution_LC103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> treeNodeQueue = new LinkedList<>();
		if (root != null){
			treeNodeQueue.offer(root);
		}
		while (!treeNodeQueue.isEmpty()){
			LinkedList<Integer> levelValue  = new LinkedList<>();
			for (int i= treeNodeQueue.size(); i>0;i--){
				TreeNode treeNode = treeNodeQueue.poll();
				if (result.size()%2 == 0){
					levelValue.addLast(treeNode.val);
				}else{
					levelValue.addFirst(treeNode.val);
				}
				if (treeNode.left != null){
					treeNodeQueue.offer(treeNode.left);
				}
				if (treeNode.right != null){
					treeNodeQueue.offer(treeNode.right);
				}
			}
			result.add(levelValue);
		}
		return result;
	}
}

// 二叉树的锯齿形层序遍历
public class LC103 {
	public static void main (String [] args) {
		Solution_LC103 solution = new Solution_LC103 ();
		TreeNode root = new TreeNode();
		Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
		root = root.CreateTreeByCe(arr);
		System.out.println (solution.zigzagLevelOrder(root));
		// 输出结果 [[3], [20, 9], [15, 7]]
	}
}