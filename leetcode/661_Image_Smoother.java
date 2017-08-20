class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = getvalue(M, i, j, m, n);
            }
        }
        return res;
    }
    private int getvalue(int[][] M, int i, int j, int m, int n) {
        int count = 1;
        int sum = M[i][j];
        if (j - 1 >= 0) {
            for (int x = i - 1; x <= i + 1; x++) {
                if (x >= 0 && x < m) {
                    count++;
                    sum += M[x][j - 1];
                    // System.out.println(x + " " + (j - 1));
                }
            }
        }
        if (i - 1 >= 0) {
            count++;
            sum += M[i - 1][j];
            // System.out.println((i - 1) + " " + j);
        }
        if (i + 1 < m) {
            count++;
            sum += M[i + 1][j];
            // System.out.println((i + 1) + " " + j);
        }
        if (j + 1 < n) {
            for (int x = i - 1; x <= i + 1; x++) {
                if (x >= 0 && x < m) {
                    count++;
                    sum += M[x][j + 1];
                    // System.out.println(x + " " + (j + 1));
                }
            }
        }
        // System.out.println(i + " "+j+" " + count + " " +sum + " "+(int) Math.floor((float) sum/ (float) count));
        return (int) Math.floor((float) sum/ (float) count);
    } 
}