// Key constrain: the number of flowers between them is k and these flowers are not blooming.
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length, ans = -1;
        int [] le = new int [n + 2];
        int [] ri = new int [n + 2];
        for(int i = 0; i <= n + 1; i++){
            le[i] = i - 1;
            ri[i] = i + 1;
        }
        for(int i = flowers.length - 1; i >= 0; i--){
            int p = flowers[i];
            int l = le[p], r = ri[p];
            if((p - l - 1 == k && l != 0) || (r - p - 1 == k && r != n + 1))
                ans = i + 1;
            ri[l] = r; le[r] = l;
        }
        return ans;
    }
}
