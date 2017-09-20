// 09.16
// Trie tree
class MapSum {

    /** Initialize your data structure here. */
    public Trie trie;
    public MapSum() {
         trie = new Trie();
    }
    
    public void insert(String key, int val) {
        Trie cur = trie;
        for (char c : key.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new Trie();
            }
            cur = cur.child[c - 'a'];
        }
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Trie cur = trie;
        for (char c : prefix.toCharArray()) {
            if (cur.child[c - 'a'] == null) return 0;
            cur = cur.child[c - 'a'];
        }
        return sumVal(cur);
    }
    
    public int sumVal(Trie node) {
        int sum = node.value;
        for (Trie child : node.child) {
            if (child != null) 
                sum += sumVal(child);
        }
        return sum;
    }
}

class Trie {
    public Trie[] child;
    public int value;
    public Trie() {
        this.child = new Trie[26];
        this.value = 0;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */


// build-in function  startWith()
    class MapSum {

        Map<String, Integer> map;
        
        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
        }
        
        public void insert(String key, int val) {
            map.put(key, val);
        }
        
        public int sum(String prefix) {
            int ret = 0;
            for(String key : map.keySet()){
                if(key.startsWith(prefix)){
                    ret += map.get(key);
                }
            }
            return ret;
        }
    }   