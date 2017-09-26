// 0922

// Time complexity is not good, O(m*n*len).
// use a hashmap to store the words, each time copy the hashmap and check whether substring start with i can be the result.
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) 
            return res;
        
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) 
            map.put(w, map.getOrDefault(w, 0) + 1);
        
        int len = words[0].length();
        for (int i = 0; i <= s.length() - words.length * len; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                String subs = s.substring(i + j * len, i + j * len + len);
                if (!copy.containsKey(subs)) {
                    break;
                } else if (copy.get(subs) == 1) {
                    copy.remove(subs);
                } else {
                    copy.put(subs, copy.get(subs) - 1);
                }
                if (copy.isEmpty()) 
                    res.add(i);
            }
        }
        return res;
    }
}
// class TrieTree{
//     TrieTree[] child;
//     boolean word;
//     public TrieTree() {
//         this.child = new TrieTree[26];
//         this.word = false;
//     }
// }