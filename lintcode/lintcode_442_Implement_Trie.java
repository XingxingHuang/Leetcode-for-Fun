// http://www.lintcode.com/en/problem/implement-trie/#
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] child;
    public boolean hasWord;
    public TrieNode() {
        child = new TrieNode[26];
        hasWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            if (now.child[word.charAt(i) - 'a'] == null) {
                now.child[word.charAt(i) - 'a'] = new TrieNode();
            }
            now = now.child[word.charAt(i) - 'a'];
        }
        now.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++)  {
            if (now.child[word.charAt(i) - 'a'] == null) {
                return false;
            }
            now = now.child[word.charAt(i) - 'a'];
        }
        return now.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (now.child[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            now = now.child[prefix.charAt(i) - 'a'];
        }
        // 如果该字符串不对应单词，并且没有后续子串，返回false
        if (!now.hasWord) {
            for (int i = 0; i < 26; i++) {
                if (now.child[i] != null) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}