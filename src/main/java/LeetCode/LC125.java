package LeetCode;

/**
 * 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * 提示：
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */
class Solution_LC125 {
    public boolean isPalindrome(String s) {
        String string = Change(s);
        int left = 0, right = string.length() - 1;
        while (left < right) {
            if(string.charAt(left) != string.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    /**
     * 去除字符串中多余的符号并将大写字母转为小写字母
     * @param s
     */
    private String Change(String s){
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        int now = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'||c >= '0' && c <= '9'){
                sb.append(c);
            }else if(c>='A' && c<='Z'){
                sb.append((char) ('a'+c-'A'));
            }
        }
        return sb.toString();
    }
}
// 验证回文串
public class LC125 {
    public static void main(String[] args) {
        Solution_LC125 solution = new Solution_LC125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));   // 输出结果 true

    }
}