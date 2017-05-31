/**
 * http://www.lintcode.com/en/problem/word-search-ii/
 * 将dictionary的words做成trie树，
 * 
 * 没做出来
 * 九章答案： http://www.jiuzhang.com/solution/word-search-ii 
 * 格式稍微修改
 * 
 */
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
         
    class TrieNode {
        String s;
        boolean isString;
        HashMap<Character, TrieNode> subtree;
        public TrieNode() {
            // TODO Auto-generated constructor stub
            isString = false;
            subtree = new HashMap<Character, TrieNode>();
            s = "";
        }
    };


    class TrieTree{
        TrieNode root ;
        public TrieTree(TrieNode TrieNode) {
            root = TrieNode;
        }
        public void insert(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    now.subtree.put(s.charAt(i), new TrieNode());
                }
                now  =  now.subtree.get(s.charAt(i));
            }
            now.s = s;
            now.isString  = true;
        }
        public boolean find(String s){
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    return false;
                }
                now  =  now.subtree.get(s.charAt(i));
            }
            return now.isString ;
        }
    };

    public int []dx = {1, 0, -1, 0};
    public int []dy = {0, 1, 0, -1};
    
    public void search(char[][] board, 
                        int x, 
                        int y, 
                        TrieNode root, 
                        ArrayList<String> ans, 
                        String res) {   
        // find the word                    
        if(root.isString == true) {
            if (!ans.contains(root.s)) {
                ans.add(root.s);
            }
        }
        // out of the bound
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]==0 || root == null)
            return;
        // loop to the four directories.
        if (root.subtree.containsKey(board[x][y])){
            for(int i = 0; i < 4; i++){
                char now = board[x][y];
                board[x][y] = 0;  //注意标记已经访问过的点!!!
                search(board, x+dx[i], y+dy[i], root.subtree.get(now), ans, res);
                board[x][y] = now;
            }
        }
        
    }
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> ans = new ArrayList<String>();
        
        TrieTree tree = new TrieTree(new TrieNode());
        for(String word : words){
            tree.insert(word);
        }
        String res = ""; 
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                // 针对每个位置寻找trie树中的单词
                search(board, i, j, tree.root, ans, res);
            }
        }
        return ans;
    }
    
}