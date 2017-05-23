// http://www.lintcode.com/en/problem/anagrams/
// 对每个字符串计算hash值。统计有重复的hash值。
// 或者直接以排序后的字符串为key，然后统计有重复的元素。
// http://www.cnblogs.com/yuzhangcmu/p/4067507.html
// http://www.jiuzhang.com/solutions/anagrams/
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    private int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }
    
    public List<String> anagrams(String[] strs) {
        // write your code here        
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        
        // 分别计算每个字符串对应的hash值。hash值至于字符串中的元素有关。
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }

        return result;
    }
}



public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> ret = new ArrayList<String>();
        if (strs == null) {
            return ret;
        }
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            
            Arrays.sort(chars);
            String sSort = new String(chars);
            
            if (map.containsKey(sSort)) {
                map.get(sSort).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sSort, list);
            }
        }
        
        // Bug 1: should use map.entrySet() instead of MAP.
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            List<String> list = entry.getValue();
            if (list.size() > 1) {
                ret.addAll(list);
            }
        }

        return ret;
    }
}