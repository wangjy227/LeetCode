package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
class Solution_LC17 {
	// 0-9对应的字母
	private static String[] res = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0){
			return new ArrayList<>();
		}
		int length = digits.length();
		Combinations(digits,0,new StringBuffer());
		return Letter;
	}
	private List<String> Letter = new ArrayList<>();
	private void Combinations(String digits,int now, StringBuffer combinations) {
		if(now == digits.length()) {
			Letter.add(combinations.toString());
			return;
		}
		int digit = digits.charAt(now) - '0';
		String chars =res[digit];
		for(int i = 0; i < chars.length(); i++) {
			combinations.append(chars.charAt(i));
			Combinations(digits,now+1,combinations);
			combinations.deleteCharAt(combinations.length()-1);
		}
	}
}
// 电话号码的字母组合
public class LC17 {
	public static void main(String[] args) {
		Solution_LC17 solution = new Solution_LC17();
		System.out.println(solution.letterCombinations("23"));
        // 输出 [ad, ae, af, bd, be, bf, cd, ce, cf]
	}
}