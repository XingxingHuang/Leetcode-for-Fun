// pq, easy but time exceed.
class Solution {
    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (j - i));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // System.out.println(i * j);
                if (pq.size() < k) {
                    pq.offer(i * j);
                } else if (pq.peek() > i * j) {
                    pq.poll();
                    pq.offer(i * j);
                } 
            }
        }
        return pq.peek();
    }
}

// binary search
// search for numbers in region of 0 to m*n, the number counts can be easily calculated
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 0, r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            int x = 0, y = 0;
            for (int i = 1; i <= m; i++) {
                int s = mid/i, kk = 0;
                if (mid % i == 0) kk = -1;
                x += Math.min(s + kk, n);
                y += Math.min(s, n);
            }
            if (x < k && y >= k) 
                return mid;
            if (y < k) l = mid + 1; else r = mid - 1;          
        }
        return l;
    }
}

// binary search
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1 , high = m * n + 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, m, n);
            if (c >= k) high = mid;
            else low = mid + 1;
        }
        
        return high;
    }
    
    private int count(int v , int m , int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i , n);
            count += temp;
        }
        return count;
    }
}