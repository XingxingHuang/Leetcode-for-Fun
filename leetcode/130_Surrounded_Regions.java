public class Solution {
    public void solve(char[][] board) {
        int rown = board.length;
        if (rown==0) return;
        int coln = board[0].length;
        for (int row=0; row<rown; ++row) {
            for (int col=0; col<coln; ++col) {
                if (row==0 || row==rown-1 || col==0 || col==coln-1) {
                    if (board[row][col]=='O') {
                        Queue<Integer> q = new LinkedList<>();
                        board[row][col]='1';
                        q.add(row*coln+col);
                        while (!q.isEmpty()) {
                            int cur = q.poll();
                            int x = cur/coln;
                            int y = cur%coln;
                            if (y+1<coln && board[x][y+1]=='O') {
                                q.add(cur+1);
                                board[x][y+1] = '1';
                            }
                            if (x+1<rown && board[x+1][y]=='O') {
                                q.add(cur+coln);
                                board[x+1][y] = '1';
                            }
                            if (y-1>=0 && board[x][y-1]=='O') {
                                q.add(cur-1);
                                board[x][y-1] = '1';
                            }
                            if (x-1>=0 && board[x-1][y]=='O') {
                                q.add(cur-coln);
                                board[x-1][y] = '1';
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<rown; ++i) {
            for (int j=0; j<coln; ++j) {
                if (board[i][j]=='O') {
                    board[i][j]='X';
                } else if (board[i][j]=='1') {
                    board[i][j]='O';
                }
            }
        }
    }
}