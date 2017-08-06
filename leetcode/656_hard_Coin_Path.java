// premium 的题目，题目可以看这里： http://bookshadow.com/weblog/2017/08/06/leetcode-coin-path/

//  modified from yijiezhu 
public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        if (n == 0 || A[n - 1] == -1) 
            return Collections.emptyList();
        
        List<Integer>[] C = (List<Integer>[]) new List[n];  // 存放路径
        int[] D = new int[n];
        Arrays.fill(D, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) 
            C[i] = new ArrayList<>();
        
        C[n - 1].add(n);
        D[n - 1] = A[n - 1];
        int end = n - 1;
        
        for (int i = n - 1; i >= 0 && i >= end; --i) {
            if (A[i] == -1) 
                continue;
            for (int j = 1; j <= B && j <= i; ++j) {
                int k = i - j;
                if (A[k] == -1) 
                    continue;
                if (D[i] + A[k] <= D[k]) {
                    C[k] = new ArrayList<>(C[i]);
                    C[k].add(k + 1);
                    end = Math.min(end, k);
                    D[k] = D[i] + A[k];
                    // System.out.println(k + ":" + C[k]);
                }
            }
        }
        if (C[0] == null) 
            C[0] = new ArrayList<>();
        Collections.reverse(C[0]);
        return C[0];
    }
}
