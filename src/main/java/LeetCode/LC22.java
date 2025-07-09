package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * 提示：
 * 1 <= n <= 8
 */
class Solution_LC22 {
	private List<String> list;
	public List<String> generateParenthesis(int n) {
		char[] str = new char[n*2];
		list = new ArrayList<String>();
		Create(str,n,n,0);
		return  list;
	}
	public void Create(char[] str,int left,int right,int now){
		if(left == 0&&right == 0){
			list.add(new String(str));
			return;
		}
		if(left<right&&right>0){
			str[now] = ')';
			Create(str,left,right-1,now+1);
		}
		if(left>0){
			str[now] = '(';
			Create(str,left-1,right,now+1);
		}
	}
}
// 括号生成
public class LC22 {
	public static void main(String[] args) {
		Solution_LC22 solution = new Solution_LC22();
		int n = 3;
		System.out.println(solution.generateParenthesis(3).toString());
	}
}