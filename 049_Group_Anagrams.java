// 黄xing
// hash思想
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strs) {
            char[] ss = s.toCharArray();
            Arrays.sort(ss);  // Arrays.sort()
            String key = String.valueOf(ss); // String.valueOf(char array)
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}