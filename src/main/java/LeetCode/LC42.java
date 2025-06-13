package LeetCode;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
class Solution_LC42 {
    public int trap(int[] height) {
        int maxleft = height[0];
        int len = height.length;
        int nums = 0;
        int maxright = height[len-1];
        int leftsum = 0;
        int rightsum = 0;
        // 分别从左向右和从右向左遍历一遍后数据为真实接到的雨水和两边多余的值，记为 s
        // 利用整个长方形减掉图形中原有的柱子，记为 t
        // 用 s 减去 t 即为接到的雨水的值
        for(int i = 0;i < len;i++){
            int right = len-i-1;
            nums += height[i];
            maxleft = Math.max(maxleft,height[i]);
            maxright = Math.max(maxright,height[right]);
            leftsum += maxleft - height[i];
            rightsum += maxright - height[right];

        }
        int sum = 0;
        sum+=leftsum+rightsum-(len*maxleft-nums);
        return sum;
    }
}
// 接雨水
public class LC42 {
    public static void main(String[] args) {
        Solution_LC42 solution = new Solution_LC42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));   // 输出 6
    }
}

