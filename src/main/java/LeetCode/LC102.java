package LeetCode;


import Method.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
class Solution_LC102 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nowlevel = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nowlevel; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                // 记录下一层节点的个数
                if (node.left != null) {
                    queue.add(node.left);
                    nextLevel++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLevel++;
                }
            }
            res.add(list);
            nowlevel = nextLevel;
            nextLevel = 0;
        }
        return res;
    }
}

/**
 * 递归解决方案
 * class Solution_LC102 {
 * 	List<List<Integer>> lists = new ArrayList<>();
 * 	public List<List<Integer>> levelOrder(TreeNode root) {
 * 		if(root == null) return lists;
 * 		Queue<TreeNode> queue = new LinkedList<TreeNode>();
 * 		queue.add(root);
 * 		LOrder(queue,1);
 * 		return lists;
 * 	    }
 * 	private void LOrder(Queue<TreeNode> queue,int number) {
 * 		List<Integer> list = new ArrayList<>();
 * 		int now = 0; // 记录新加入队列的数据个数，即下一层数的个数
 * 		while(number > 0){
 * 			TreeNode node = queue.poll();
 * 			list.add(node.val);
 * 			if(node.left != null) {
 * 				queue.add(node.left);
 * 				now++;
 *            }
 * 			if(node.right != null) {
 * 				queue.add(node.right);
 * 				now++;
 *            }
 * 			number--;
 *        }
 * 		lists.add(list);
 * 		if(now > 0) {
 * 			LOrder(queue, now);
 *        }
 *    }
 *
 * }
 */

// 二叉树的层序遍历
public class LC102 {
    public static void main(String[] args) {
        Solution_LC102 solution = new Solution_LC102();
        TreeNode root = new TreeNode();
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        root = root.CreateTreeByCe(arr);
        System.out.println(solution.levelOrder(root));
        // 输出 [[3], [9, 20], [15, 7]]
    }
}