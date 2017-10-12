class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i), i);
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}

// 10.11 Using hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int max = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - ' ';
            len = (map[idx] == -1) ? len + 1 : Math.min(i - map[idx], len + 1);
            map[idx] = i;
            max = Math.max(len, max);
        }
        return max;
    }
}