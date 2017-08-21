// 2017.08.20 XingxingHuang 
class Solution {
    public static int maxProduct(String[] words) {
        if (words == null || words.length <= 1)
            return 0;
        int m = words.length;
        // convert to binary
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] = nums[i] | (1 << (words[i].charAt(j) - 'a'));
            }
        }
        // compare with O(n^2);
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if ((nums[i] & nums[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}