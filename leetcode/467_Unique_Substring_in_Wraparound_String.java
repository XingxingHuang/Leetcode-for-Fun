// 10.05
// @Xingxing
// 很容易想到暴力方法，找出所有连续的子串，然后统计子串的个数。但是不同的连续子串会有重复的子串出现，不能直接用数学的方法快速计算结果。
// 这里用了一个很巧妙的方法，对于每个连续子串，我们只需要标记以某个元素结尾的最长连续子串。这样我们就可以记录所有连续子串的情形。
// 有了这个存储方式就可以很容易计算不一样子串的数量，即将记录的以某一字母结尾子串长度相加求和即可。
class Solution {
    public int findSubstringInWraproundString(String p) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (count == 0 || p.charAt(i) == p.charAt(i-1) + 1 || (p.charAt(i) == 'a' && p.charAt(i-1) == 'z')) {
                count++;
            } else {
                count = 1;
            }
            map.put(p.charAt(i), Math.max(map.getOrDefault(p.charAt(i), 0), count));
        }
        int res = 0;
        for (char c: map.keySet()) 
            res += map.get(c);
        return res;
    }
}