package LeetCode;

import Method.TreeNode;

/**
 * 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * 提示：
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
class Solution_LC104 {
    private int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }
    public void dfs(TreeNode root, int depth) {
        if(root == null){
            maxDepth = Math.max(maxDepth, depth-1);
            return;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
// 二叉树的最大深度
public class LC104 {
    public static void main(String[] args) {
        Solution_LC104 solutionLC = new Solution_LC104();
        TreeNode root = new TreeNode();
        Integer[] arr = {3,9,20,null,null,15,7};
        root = root.CreateTreeByCe(arr);
        System.out.println(solutionLC.maxDepth(root));  // 输出 3
    }
}
