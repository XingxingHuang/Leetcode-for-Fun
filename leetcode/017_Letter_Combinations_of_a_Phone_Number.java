// 09.15
class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        helper(digits, 0, res, "");
        return res;
    }
    private void helper(String digits, int idx, List<String> res, String str) {
        if (idx == digits.length()) {
            if (str.length() == 0) return;
            res.add(str);
            return;
        }
        String key = KEYS[digits.charAt(idx) - '0'];
        for (int i = 0; i < key.length(); i++) {
            helper(digits, idx + 1, res, str + key.charAt(i));
        }
    }
}