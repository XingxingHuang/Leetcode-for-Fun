// 2017.09.12
// should re do !!!  check the discussions



class Solution {
    public String nearestPalindromic(String n) {
        char[] arr = n.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) arr[j] = arr[i];

        String curP = String.valueOf(arr);
        String preP = nearestPalindrom(curP, false);
        String nextP = nearestPalindrom(curP, true);

        long num = Long.valueOf(n);
        long cur = Long.valueOf(curP);
        long pre = Long.valueOf(preP);
        long next = Long.valueOf(nextP);

        long d1 = Math.abs(num - pre);
        long d2 = Math.abs(num - cur);
        long d3 = Math.abs(num - next);

        if (num == cur) {
            return d1 <= d3 ? preP : nextP;
        } else if (num > cur) {
            return d2 <= d3 ? curP : nextP;
        } else {
            return d1 <= d2 ? preP : curP;
        }
    }

    private String nearestPalindrom(String curP, boolean dir) {
        int k = curP.length() >> 1, p = curP.length() - k;
        int l = Integer.valueOf(curP.substring(0, p));
        l += (dir ? 1 : -1);

        if (l == 0) return k == 0 ? "0" : "9";

        StringBuilder left = new StringBuilder(String.valueOf(l));
        StringBuilder right = new StringBuilder(left).reverse();
        if (k > left.length()) right.append("9");

        return left.append(right.substring(right.length() - k)).toString();
    }
}