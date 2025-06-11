package Method;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 简单二叉树
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode InitFirst(Integer[] arr) {
        TreeNode Head = CreateTreeFirst(arr);
        return Head;
    }

    public TreeNode Init(int[] arr) {
        TreeNode Head = CreateTree(arr);
        return Head;
    }

    public int now = 0;

    /**
    *先序遍历生成树 1,2,null,4,null,null,5,6,null,null,7,null,null
            1
         2     5
           4 6   7
     */
    private TreeNode CreateTreeFirst(Integer[] arr) {
        TreeNode Temp = null;
        if (now >= arr.length) {
            return null;
        }
        if (arr[now] == null) {
            Temp = null;
            now++;
        } else {
            Temp = new TreeNode(arr[now]);
            now++;
            Temp.left = CreateTreeFirst(arr);
            Temp.right = CreateTreeFirst(arr);
        }
        return Temp;
    }
    /**
    *按照数组顺序生成树，按顺序生成
     */
    private TreeNode CreateTree(int[] arr){
        int length = arr.length;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(arr[0]);
        q.add(root);
        int now = 1;
        while (now < length){
            TreeNode node = q.poll();
            if(now < length){
                node.left = new TreeNode(arr[now++]);
                q.add(node.left);
            }
            if(now < length){
                node.right = new TreeNode(arr[now++]);
                q.add(node.right);
            }
        }
        return root;
    }

    /**
     * 打印二叉树所有节点
     * @param treeNode
     */
    public void PrintAll(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(treeNode.val + " ");
        PrintAll(treeNode.left);
        PrintAll(treeNode.right);
    }
}


