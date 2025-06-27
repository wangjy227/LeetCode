package LeetCode;

/**
 * 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。
 * 示例 1：
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：
 * 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。
 * 示例 2：
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */

// 查找被包围的岛屿并标记
class Solution_LC130_1 {
    private int m;
    private int n;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (DFS_Find(board, i, j)) {
                        Change = 'X';
                        DFS_Change(board, i, j);
                    } else {
                        Change = 'O';
                        DFS_Change(board, i, j);
                    }
                }
            }
        }
    }

    private char Change;

    private boolean DFS_Find(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            boolean l1 = DFS_Find(board, i + 1, j);
            boolean l2 = DFS_Find(board, i - 1, j);
            boolean l3 = DFS_Find(board, i, j + 1);
            boolean l4 = DFS_Find(board, i, j - 1);
            return l1 && l2 && l3 && l4;
        }
        return true;
    }

    private void DFS_Change(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (board[i][j] == '1') {
            board[i][j] = Change;
            for(int[] dir:dirs){
                DFS_Change(board, i+dir[0], j+dir[1]);
            }
        }
    }
}
// 找未被包围的岛屿并标记，剩下的岛屿为被包围的岛屿
class Solution_LC130_2 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        // 只遍历边缘数据，如果存在边缘岛屿，则此岛屿未被包围
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                DFS_Find(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                DFS_Find(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                DFS_Find(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                DFS_Find(board, m - 1, j);
            }
        }
        DFS_Change(board);
    }
    
    private void DFS_Change(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    // 
    private void DFS_Find(char[][] board, int i, int j) {
        if(i<0||i>board.length-1||j<0||j>board[0].length-1){
            return;
        }
        if(board[i][j]=='O'){
            board[i][j] = 'N';
            for(int[] dir:dirs){
                DFS_Find(board, i+dir[0], j+dir[1]);
            }
        }
    }
}

// 被围绕的区域
public class LC130 {
    public static void main(String[] args) {
        Solution_LC130_2 solution = new Solution_LC130_2();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        DFS_Print(board);
        solution.solve(board);
        System.out.println();
        DFS_Print(board);
    }
    private static void DFS_Print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }
}