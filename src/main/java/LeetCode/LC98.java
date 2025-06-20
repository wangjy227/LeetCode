package LeetCode;

import Method.TreeNode;

/**
 * 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * 提示：
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
class Solution_LC98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return CheckBST(root.left, root.val, Long.MIN_VALUE) && CheckBST(root.right, Long.MAX_VALUE, root.val);
    }
    private boolean CheckBST(TreeNode treeNode, long max, long min) {
        if (treeNode == null) return true;
        if (treeNode.val >= max || treeNode.val <= min) return false;
        return CheckBST(treeNode.left, treeNode.val, min) && CheckBST(treeNode.right, max, treeNode.val);
    }
}

// 验证二叉搜索树
public class LC98 {
    public static void main(String[] args) {
        Solution_LC98 solution = new Solution_LC98();
        TreeNode root = new TreeNode();
        Integer[] arr = {-2147483648,null,2147483647};
        root = root.CreateTreeByCe(arr);
        System.out.println(solution.isValidBST(root));
        // 输出 true
    }
}