// https://discuss.leetcode.com/topic/102033/java-o-1/2
class Solution {
    public int flipLights(int n, int m) {
        if(m==0) return 1;
        if(n==1) return 2;
        if(n==2&&m==1) return 3;
        if(n==2) return 4;
        if(m==1) return 4;
        if(m==2) return 7;
        if(m>=3) return 8;
        return 8;
    }
}

// python 
def flipLights(self, n, m):
    if m == 0:      
        return 1
    if n == 1:
        return 2
    if m == 1 and n == 2:
        return 3
    if m == 1 or n == 2:
        return 4
    if m == 2:
        return 7
    return 8
    

//bfs https://discuss.leetcode.com/topic/102107/easy-to-understand-java-bfs-solution-o-m
public int flipLights(int n, int m) {
        n = n <= 6? n: (n % 6 + 6);
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int init = (1 << n) - 1;
        queue.offer(init);
        for (int i=0; i<m; i++) {
            int size = queue.size();
            visited.clear();
            for (int k=0; k<size; k++) {
                int s = queue.poll();
                int[] next = new int[] {flipAll(s, n), 
                     flipEven(s, n), flipOdd(s, n), flip3k1(s, n)};
                for (int s1: next) {
                    if (!visited.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                }
            }
        }
        return queue.size();
    }
    
    private int flipAll(int s, int n) {
        int x = (1 << n) - 1;
        return s ^ x;
    }

    private int flipEven(int s, int n) {
        for (int i=0; i<n; i+=2) {
            s ^= 1 << i;
        }
        return s;
    }

    private int flipOdd(int s, int n) {
        for (int i=1; i<n; i+=2) {
            s ^= 1 << i;
        }
        return s;
    }

    private int flip3k1(int s, int n) {
        for (int i=0; i<n; i+=3) {
            s ^= 1 << i;
        }
        return s;
    }