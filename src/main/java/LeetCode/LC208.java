package LeetCode;

/**
 * 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；
 * 否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；
 * 否则，返回 false 。
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */

class Trie{
    private Trie[] nextChars;
    private boolean end;
    public Trie() {
        nextChars = new Trie[26];
        end = false;
    }
    public void insert(String word) {
        char[] ch = word.toCharArray();
        Trie cur = this;
        for(int i = 0;i < ch.length;i++){
            if(cur.nextChars[ch[i]-'a'] == null){
                cur.nextChars[ch[i]-'a'] = new Trie();
            }
            cur = cur.nextChars[ch[i]-'a'];
            if(i == ch.length-1){
                cur.end = true;
            }
        }
    }
    public boolean search(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.nextChars[word.charAt(i) - 'a'] != null) {
                cur = cur.nextChars[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.nextChars[prefix.charAt(i) - 'a'] != null) {
                cur = cur.nextChars[prefix.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}


// 实现 Trie (前缀树)
public class LC208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));   // 返回 false
        System.out.println(trie.search("app"));     // 返回 true
        System.out.println(trie.search("ad"));     // 返回 false
        System.out.println(trie.search("applepie"));   // 返回 false
        System.out.println(trie.search("rest"));     // 返回 false
        System.out.println(trie.search("jan"));     // 返回 false
        System.out.println(trie.search("rent"));   // 返回 false
        System.out.println(trie.search("beer"));     // 返回 true
        System.out.println(trie.search("jam"));     // 返回 true
        System.out.println(trie.startsWith("apps")); // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        System.out.println(trie.startsWith("ad")); // 返回 true
        System.out.println(trie.startsWith("applepie")); // 返回 false
        System.out.println(trie.startsWith("rest")); // 返回 false
        System.out.println(trie.startsWith("jan")); // 返回 false
        System.out.println(trie.startsWith("rent")); // 返回 true
        System.out.println(trie.startsWith("beer")); // 返回 true
        System.out.println(trie.startsWith("jam")); // 返回 true
    }
}