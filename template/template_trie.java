
// Version 1: Array of TrieNode
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    private TrieNode[] children;
    public boolean hasWord;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
    
    public void insert(String word, int index) {
        if (index == word.length()) {
            this.hasWord = true;
            return;
        }
        
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }
    
    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }
        
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node != null && node.hasWord);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}


// Version 2: HashMap Version
/*
Your Trie object will be instantiated and called as such:
Trie trie = new Trie();
trie.insert("lintcode");
trie.search("lint"); will return false
trie.startsWith("lint"); will return true
*/
class TrieNode {
    // Initialize your data structure here.
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean hasWord;
    
    public TrieNode(){
        
    }
    
    public TrieNode(char c){
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){
            char wc = wordArray[i];
            if(curChildren.containsKey(wc)){
                cur = curChildren.get(wc);
            } else {
                TrieNode newNode = new TrieNode(wc);
                curChildren.put(wc, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if(i == wordArray.length - 1){
                cur.hasWord= true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(searchWordNodePos(word) == null){
            return false;
        } else if(searchWordNodePos(word).hasWord) 
          return true;
          else return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchWordNodePos(prefix) == null){
            return false;
        } else return true;
    }
    
    public TrieNode searchWordNodePos(String s){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++){
            char c = sArray[i];
            if(children.containsKey(c)){
                cur = children.get(c);
                children = cur.children;
            } else{
                return null;
            }
        }
        return cur;
    }
}