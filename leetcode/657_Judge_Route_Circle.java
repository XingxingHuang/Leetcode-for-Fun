    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(char c: moves.toCharArray()){
            x += (c=='R'?1:0) + (c=='L'?-1:0); y += (c=='U'?1:0) + (c=='D'?-1:0);
        }
        return x == 0 && y == 0;
    }