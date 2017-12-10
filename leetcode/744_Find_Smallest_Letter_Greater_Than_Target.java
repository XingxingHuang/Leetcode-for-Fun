// 12.09 contest 62
// easy 题目二分法练习
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (letters[m] - target <= 0) {
                l = m + 1;
            } else {
                r = m;
            }
            if (l == letters.length)
                return letters[0];
        }
        return letters[l];
    }
}