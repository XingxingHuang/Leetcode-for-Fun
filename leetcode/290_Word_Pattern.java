// @Author: Xingxing Huang
// @Date: 2017/03/24
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            // map.put will return 'value' if 'key' exists, else it will return null 
            if (map.put(pattern.charAt(i), i) !=  map.put(words[i], i)) {
                return false;
            }
        }    
        return true;
    }
}