// 12.30 hard
class Solution {
    public int intersectionSizeTwo(int[][] rs) {
        Arrays.sort(rs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int n = rs.length;
        int p = 0;
        int[] xs = new int[n*2+5];
        for(int[] r : rs){
            int rem = 2;
            for(int i = 0;i < p;i++){
                if(r[0] <= xs[i] && xs[i] <= r[1]){
                    rem--;
                }
            }
            for(int i = 0;i < rem;i++){
                xs[p++] = r[1] - i;
            }
        }
        return p;
    }
}   