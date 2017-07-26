// @Author: Xingxing Huang
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) 
            return res;
        int[] flag = new int[n];
        dfs(n, flag, res, 0);
        return res;
    }
    private void dfs(int n, int[] flag, List<List<String>> res, int count) {
        if (count == n) {
            construct(n, flag, res);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, flag, count ,i)) {
                flag[count] = i;
                dfs(n, flag, res, count + 1);
            }
        }
    }
    private boolean valid(int n, int[] flag, int x, int y) {
        for (int i = 0; i < x; i++) {
            // cannot in 
            if (x + y == i + flag[i] || x - y == i - flag[i] || y == flag[i]) 
                return false;
        }
        return true;
    }
    private void construct(int n, int[] flag, List<List<String>> res) {
        res.add(new ArrayList<String>());
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                str += flag[i] == j ? "Q" : ".";
            }
            res.get(res.size() - 1).add(str);
        }
    }
}


// Download from discussion
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) { // attention: y
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))  // attention
                    return false;
            }
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) { 
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}


// @Author: Xingxing Huang
// time exceed
// flag数组来判断是否访问过是冗余的，可以去掉。dfs中可以只有一重循环，因为每一个Q必为不同行
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) 
            return res;
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                chars[i][j] = '.';
        }
        dfs(n, chars, res, 0);
        return res;
    }
    private void dfs(int n, char[][] chars, List<List<String>> res, int count) {
        // stop condition 
        if (count == n) {
            convert(chars, res, n);
            return;
        }
        // recursive
        for (int i = count; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (valid(i, j, chars, n)) {
                    chars[i][j] = 'Q';
                    dfs(n, chars, res, count + 1);
                    chars[i][j] = '.';
                }
            }
        }
    }
    private void convert(char[][] chars, List<List<String>> res, int n) {
        res.add(new ArrayList<String>());
        for (int i = 0; i < n; i++) {
            res.get(res.size() - 1).add(new String(chars[i]));
        }
    }
    private boolean valid (int x, int y, char[][] chars, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[i][j] == 'Q' && (x - y == i - j || x + y == i + j || x == i || y == j))
                    return false;
            }
        }
        return true;
    }
}


// 没通过代码，看错题目，看成了皇后是横竖行无法共存的关系
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) 
            return res;
        int[][] visited = new int[n][n];
        dfs(visited, n, res, 0);
        return res;
    }
    private void dfs(int[][] visited, int n, List<List<String>> res, int count) {
        if (count == n) {
            add_result(visited, res, n);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {  // 0: no visited, 1: no queue but visited, 2: cannot set, 3: has queue
                    int[] tmp1 = new int[n];
                    int[] tmp2 = new int[n];
                    for (int k = 0; k < n; k++) { // set flags
                        tmp1[k] = visited[k][j];
                        tmp2[k] = visited[i][k];
                        visited[k][j] = 2;
                        visited[i][k] = 2;
                    }
                    visited[i][j] = 3;
                    dfs(visited, n, res, count + 1); //dfs
                    for (int k = 0; k < n; k++) { // roll back
                        visited[k][j] = tmp1[k];
                        visited[i][k] = tmp2[k];
                    }
                    visited[i][j] = 1; // set as visited
                    // System.out.println("____");
                    // for (int i1 = 0; i1 < n; i1++) 
                    //     for (int i2 = 0; i2 < n; i2++)
                    //         System.out.println(visited[i1][i2]);
                } 
            }
        }
    }
    private void add_result(int[][] visited, List<List<String>> res, int n) {
        res.add(new ArrayList<String>());
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 3) 
                    str += "Q";
                else
                    str += ".";
            }
            res.get(res.size() - 1).add(str);
        }
    }
}