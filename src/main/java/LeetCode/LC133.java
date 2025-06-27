package LeetCode;

import java.util.*;

/**
 * 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * 示例 1：
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * 示例 2：
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * 示例 3：
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * 提示：
 * 这张图中的节点数在 [0, 100] 之间。
 * 1 <= Node.val <= 100
 * 每个节点值 Node.val 都是唯一的，
 * 图中没有重复的边，也没有自环。
 * 图是连通图，你可以从给定节点访问到所有节点。
 */

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// 通过 队列que_old 记录即将遍历的节点，通过 visited 记录已经修改过的节点
class Solution_LC133_1 {
    private Map<Integer,Node> visited = new HashMap<Integer,Node>();
    private Queue<Node> que_old = new LinkedList<Node>();
	public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node clone = new Node(node.val);
        que_old.add(node);
        visited.put(clone.val,clone);
        dfs();
        return clone;
	}
    // visited 判断节点是否遍历过，que 存储将要遍历的节点
    private void dfs() {
        while(!que_old.isEmpty()) {
            Node oldNode = que_old.poll();
            Node newNode = visited.get(oldNode.val);
            List<Node> newNeighbors = newNode.neighbors;
            List<Node> neighbors = oldNode.neighbors;
            for (Node neighbor : neighbors) {
                Node newNeighbor = visited.getOrDefault(neighbor.val,new Node(neighbor.val));
                newNeighbors.add(newNeighbor);
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(newNeighbor.val, newNeighbor);
                    que_old.add(neighbor);
                }
            }
            // 将周围节点进行赋值
            newNode.neighbors = newNeighbors;
        }
    }
}

class Solution_LC133_2 {
    private HashMap <Node, Node> visited = new HashMap <> ();//键为原图节点，值为对应的克隆节点，用于避免重复克隆和处理循环引用，记录已克隆的节点。
    // 深度优先遍历
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;// 空节点直接返回
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));// 克隆邻居并添加到当前节点
        }
        return cloneNode;
    }
}
// 克隆图
public class LC133 {
	public static void main(String[] args) {
        Solution_LC133_1 solution = new Solution_LC133_1();
        Node n1 = Init();
        System.out.println("初始："+n1);
        PrintNode(n1);
		n1 = solution.cloneGraph(n1);
        System.out.println("克隆体："+n1);
        PrintNode(n1);
        /**
         * 节点值->1 ,邻居 -> [2 ,3 ,]
         * 节点值->2 ,邻居 -> [1 ,4 ,]
         * 节点值->3 ,邻居 -> [1 ,4 ,]
         * 节点值->4 ,邻居 -> [2 ,3 ,]
         * 节点值->1 ,邻居 -> [2 ,3 ,]
         * 节点值->2 ,邻居 -> [1 ,4 ,]
         * 节点值->3 ,邻居 -> [1 ,4 ,]
         * 节点值->4 ,邻居 -> [2 ,3 ,]
         */
	}
    // 初始化测试用例
    private static Node Init(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n2.neighbors.add(n1);
        n2.neighbors.add(n4);
        n3.neighbors.add(n1);
        n3.neighbors.add(n4);
        n4.neighbors.add(n2);
        n4.neighbors.add(n3);
        return n1;
    }
    // 输出测试用例
    private static void PrintNode(Node node) {
        Queue<Node> q = new LinkedList<Node>();
        Map<Node,Boolean> visited = new HashMap<Node,Boolean>();
        visited.put(node, true);
        q.add(node);
        while(!q.isEmpty()) {
            Node temp = q.poll();
            List<Node> neighbors = temp.neighbors;
            System.out.print("节点值->"+temp.val);
            System.out.print(" ,邻居 -> [");
            for(Node neighbor : neighbors) {
                if(!visited.containsKey(neighbor)) {
                    q.add(neighbor);
                    visited.put(neighbor, true);
                }
                System.out.print(neighbor.val+" ,");
            }
            System.out.println("]");
        }
    }
}