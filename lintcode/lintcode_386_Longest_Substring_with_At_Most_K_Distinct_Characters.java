// http://www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/#
// @Author: Xingxing Huang
// @Notice: Attention for the corner case
// @Method: Using hashmap to save the occurences of each character.
// @Time: O(N)
public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (k == 0 || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        int j = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!map.containsKey(s.charAt(j))) {
                    if (map.size() == k) {  //只能在这里跳出才能得到正确答案
                        break;              //不能将判断放入while循环中。
                    }
                    map.put(s.charAt(j), 1);
                } else {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                }
                j++;
            }
            ans = Math.max(ans, j - i);
            if (map.get(s.charAt(i)) == 1) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }
        return ans;
    }
}