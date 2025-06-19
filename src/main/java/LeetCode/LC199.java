package LeetCode;

import Method.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1：
 * 输入：root = [1,2,3,null,5,null,4]
 * 输出：[1,3,4]
 * 解释：
 * 示例 2：
 * 输入：root = [1,2,3,4,null,null,null,5]
 * 输出：[1,3,4,5]
 * 解释：
 * 示例 3：
 * 输入：root = [1,null,3]
 * 输出：[1,3]
 * 示例 4：
 * 输入：root = []
 * 输出：[]
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
class Solution_LC199 {
    private List<Integer> res = new ArrayList<>();
    private int MAX = 0;

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return res;
    }
    // 利用 MAX 记录存入LIST的最大值，depth为当前所在层数，
    // 向右遍历，记录节点的值
    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > MAX) {
            res.add(root.val);
            MAX = depth;
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}

// 二叉树的右视图
public class LC199 {
    public static void main(String[] args) {
        Solution_LC199 solution = new Solution_LC199();
        TreeNode root = new TreeNode();
        Integer[] arr = new Integer[]{1, 2, 3, null, 5, null, 4};
        root = root.CreateTreeByCe(arr);
        System.out.println(solution.rightSideView(root));
        // 输出 [1, 3, 4]
    }
}