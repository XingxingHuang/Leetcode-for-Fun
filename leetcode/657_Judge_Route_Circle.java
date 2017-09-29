    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(char c: moves.toCharArray()){
            x += (c=='R'?1:0) + (c=='L'?-1:0); y += (c=='U'?1:0) + (c=='D'?-1:0);
        }
        return x == 0 && y == 0;
    }
    
class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)
            return true;
        int[] count = new int[2];
        for (char c : moves.toCharArray()) {
            if (c == 'U') count[0]++;
            if (c == 'D') count[0]--;
            if (c == 'L') count[1]++;
            if (c == 'R') count[1]--;
        }
        for (int i = 0; i < count.length; i++) 
            if (count[i] != 0) return false;
        return true;
    }
}