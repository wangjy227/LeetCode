package LeetCode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 */
class LC117_Node {
    public int val;
    public LC117_Node left;
    public LC117_Node right;
    public LC117_Node next;

    public LC117_Node() {
    }

    public LC117_Node(int _val) {
        val = _val;
    }

    public LC117_Node(int _val, LC117_Node _left, LC117_Node _right, LC117_Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

/**
 * 			1
 * 		2		3
 * 	  4	   5		7
 * <p>
 * 			1 -> null
 * 		2 ->	3 -> null
 * 	  4-> 5->			7 -> null
 */
class Solution_LC117 {
    public LC117_Node connect(LC117_Node root) {
        // 存储二叉树的节点
        Queue<LC117_Node> quearr = new LinkedList<>();
        // 存储节点所在的层数
        Queue<Integer> quenum = new LinkedList<>();
        quearr.add(root);
        quenum.add(0);
        create(quearr, quenum);
        return root;
    }

    private void create(Queue<LC117_Node> quearr, Queue<Integer> quenum) {
        if(quearr.isEmpty()||quenum.isEmpty()) return;
        // 获得首个节点的 Node值 和 所在层数
        int n = quenum.poll();
        LC117_Node cur = quearr.poll();
        while (cur!=null) {
            LC117_Node t;
            // 如果在相同的层数就获取节点作为上一个节点的 next值，否则为 null
            if(!quenum.isEmpty()&&quenum.peek() == n){
                t = quearr.poll();
                quenum.poll();
            }else{
                t = null;
            }
            cur.next = t;
            // 将当前节点的 左子树 和 右子树 存入队列
            if (cur.left != null) {
                quenum.add(n + 1);
                quearr.add(cur.left);
            }
            if (cur.right != null) {
                quenum.add(n + 1);
                quearr.add(cur.right);
            }
            cur = t;
        }
        create(quearr, quenum);
    }
}

// 填充每个节点的下一个右侧节点指针 II
public class LC117 {
    public static void main(String[] args) {
        Solution_LC117 solution = new Solution_LC117();
        LC117_Node root = new LC117_Node(1);
        LC117_Node root_l = new LC117_Node(2);
        LC117_Node root_r = new LC117_Node(3);
        LC117_Node root_l_l = new LC117_Node(4);
        LC117_Node root_l_r = new LC117_Node(5);
        LC117_Node root_r_r = new LC117_Node(7);
        root.left = root_l;
        root.right = root_r;
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        root_r.right = root_r_r;
        solution.connect(root);
        System.out.println(solution);
    }
}