package LeetCode;

import java.util.*;

/**
 * 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 */

// 解决问题超时，能否记录之前查找到的路径
class Solution_LC212 {
	// 字母图，查找字符串数组中是否在字母图中有匹配的，查找第一个字母耗时较多，
	// 用Map存储所有字母在字母图中的位置？	Map<Character,List<Integer[]>>

	// 查找后续字母如何确定是否遍历过周围字母
	// 图中数据加标记？ 查找其他字符串需要去除标记
	// 记录去过的位置，遍历时判断？ 每一个字符串需建立独自的记录 Set<Integer[]>

	//
	public List<String> findWords(char[][] board, String[] words) {
		Map<Character,List<Integer[]>> map = new HashMap<>();
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				List<Integer[]> t = map.getOrDefault(board[i][j], new ArrayList<>());
				t.add(new Integer[]{i,j});
				map.put(board[i][j],t);
			}
		}
		for(int i = 0; i < words.length; i++){
			if(map.containsKey(words[i].toCharArray()[0])){
				List<Integer[]> temp = map.get(words[i].toCharArray()[0]);
				for(int j = 0; j < temp.size(); j++){
					Find(board,words[i],temp.get(j)[0],temp.get(j)[1],0,new HashSet<>());
				}
			}
		}
		return new ArrayList<>(res);
	}
	private Set<String> res = new HashSet<>();
	private void Find(char[][] board, String word,int i,int j,int index,Set<Integer> set) {
		// 出界或者已经用过 直接返回
		if(i<0||j<0||i>=board.length||j>=board[0].length||set.contains(i*20+j)){// set检测不出是否用过，因为用new Integer检测
			return;
		}
		if(index==word.length()-1&&board[i][j]==word.charAt(index)){
			res.add(word);
			return;
		}

		if(board[i][j]==word.charAt(index)){
			set.add(i*20+j);	// 走到错误路径会存储对应数据，当再走到该节点会判定已走过
			Find(board,word,i+1,j,index+1,set);	// 下
			Find(board,word,i-1,j,index+1,set); // 上
			Find(board,word,i,j-1,index+1,set); // 左
			Find(board,word,i,j+1,index+1,set); // 右
		}
		// 当该道路不通时清除数据
		set.remove(i*20+j);

		// 0  1  2
		// 20 21 22
		// 40 41 42
	}
}
// 单词搜索 II
public class AAA_LC212 {
	public static void main(String[] args) {
		Solution_LC212 solution = new Solution_LC212();
//		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//		String[] words = {"oath","pea","eat","rain"};
		char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
		String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
		// ["abcdefg","befa","eaabcdgfa","gfedcbaaa"]
		System.out.println(solution.findWords(board, words));
	}
}