package LeetCode;

/**
 * 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。
 * word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // 返回 False
 * wordDictionary.search("bad"); // 返回 True
 * wordDictionary.search(".ad"); // 返回 True
 * wordDictionary.search("b.."); // 返回 True
 * 提示：
 * 1 <= word.length <= 25
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 104 次 addWord 和 search
 */
class WordDictionary_LC211 {
    private WordDictionary_LC211[] dict;
    private boolean ISEND;

    public WordDictionary_LC211() {
        dict = new WordDictionary_LC211[26];
        ISEND = false;
    }

    public void addWord(String word) {
        WordDictionary_LC211 wordDictionaryLC211 = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (wordDictionaryLC211.dict[chars[i] - 'a'] == null) {
                wordDictionaryLC211.dict[chars[i] - 'a'] = new WordDictionary_LC211();
            }
            wordDictionaryLC211 = wordDictionaryLC211.dict[chars[i] - 'a'];
            if (i == chars.length - 1) {
                wordDictionaryLC211.ISEND = true;
            }
        }
    }

    public boolean search(String word) {
        return SearchHelp(this, word.toCharArray(), -1);
    }

    private boolean SearchHelp(WordDictionary_LC211 wordDictionaryLC211, char[] chars, int index) {
        for (int i = index + 1; i < chars.length; i++) {
            // 当搜索的字符为 . 时，需要遍历当前节点所有 字符
            if (chars[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (wordDictionaryLC211.dict[j] != null) {
                        // 递归进行判断，当返回结果为 true 时，说明存在匹配的字符
                        if (SearchHelp(wordDictionaryLC211.dict[j], chars, i)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                // 如果不是 . 则直接查找当前节点是否存在相应字符，存在就向下遍历
                if (wordDictionaryLC211.dict[chars[i] - 'a'] != null) {
                    wordDictionaryLC211 = wordDictionaryLC211.dict[chars[i] - 'a'];
                } else {
                    return false;
                }
            }
        }
        // 当匹配完所有 chars 字符且当前节点是终点（字典树中存在从根节点到当前节点的字符串），返回 true
        return wordDictionaryLC211.ISEND;
    }
}

// 添加与搜索单词 - 数据结构设计
public class LC211 {
    public static void main(String[] args) {
//        WordDictionary_LC211 wordDictionaryLC211 = new WordDictionary_LC211();
//        wordDictionaryLC211.addWord("a");
//        wordDictionaryLC211.addWord("a");
//        System.out.println(wordDictionaryLC211.search(".")); // 返回 False
//        System.out.println(wordDictionaryLC211.search("a")); // 返回 True
//        System.out.println(wordDictionaryLC211.search("aa")); // 返回 True
//        System.out.println(wordDictionaryLC211.search("a.")); // 返回 True
        WordDictionary_LC211 wordDictionaryLC211 = new WordDictionary_LC211();
        wordDictionaryLC211.addWord("bad");
        wordDictionaryLC211.addWord("dad");
        wordDictionaryLC211.addWord("mad");
        System.out.println(wordDictionaryLC211.search("pad")); // 返回 False
        System.out.println(wordDictionaryLC211.search("bad")); // 返回 True
        System.out.println(wordDictionaryLC211.search(".ad")); // 返回 True
        System.out.println(wordDictionaryLC211.search("b..")); // 返回 True
    }
}