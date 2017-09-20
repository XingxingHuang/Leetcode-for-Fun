// Using Trie 
class MagicDictionary {
    private TrieNode trie;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.trie = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            TrieNode cur = trie;
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new TrieNode();
                }
                cur = cur.child[idx];
            }
            cur.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        for (int i = 0; i < word.length(); i++) {
            TrieNode cur = trie;
            int idx = 0; 
            while (idx < i && cur.child[word.charAt(idx) - 'a'] != null) {
                cur = cur.child[word.charAt(idx) - 'a'];
                idx++;
            }
            if (idx != i) continue;
            int temp = idx;
            TrieNode curtemp = cur;
            for (int j = 0; j < 26; j++) {
                idx = temp + 1;
                cur = curtemp;
                if (j == word.charAt(temp) - 'a' || cur.child[j] == null) 
                    continue;
                cur = cur.child[j];
                while (idx < word.length() && cur.child[word.charAt(idx) - 'a'] != null) {
                    cur = cur.child[word.charAt(idx) - 'a'];
                    idx++;
                }
                if (idx == word.length() && cur.isWord) 
                    return true;
            }
        }
        return false;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] child;
    public TrieNode() {
        this.child = new TrieNode[26];
        this.isWord = false;
    }
}



// using hashset
class MagicDictionary {

    /** Initialize your data structure here. */
    Set<String> set;
    public MagicDictionary() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict){
            set.add(word);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] input = word.toCharArray();
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < 26; j++){
                if(word.charAt(i) == (char)(j+'a')){
                    continue;
                }
                input[i] = (char)(j+'a');
                if(set.contains(new String(input))){
                    return true;
                }
            }
            input[i] = word.charAt(i);
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */