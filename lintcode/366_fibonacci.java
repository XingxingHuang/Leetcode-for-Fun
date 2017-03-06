class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int cur = 0;
        int next = 1;
        int i = 1;
        while (i < n) {
            int temp = cur + next;
            cur = next;
            next = temp;
            i++;
        }
        return cur;
    }
}

