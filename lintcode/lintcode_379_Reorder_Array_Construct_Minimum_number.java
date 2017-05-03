// http://www.lintcode.com/en/problem/reorder-array-to-construct-the-minimum-number/
// http://www.jiuzhang.com/solutions/reorder-array-to-construct-the-minimum-number/
public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return "0";
        }
        // 字符串
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 排序
        // 错误 Arrays.sort(strs, (a, b) -> (a.concat(b).compareTo(b.concat(a))) );
        Arrays.sort(strs, new Comparator<String>() {
           public int compare (String a, String b) {
               return a.concat(b).compareTo(b.concat(a));
           } 
        });
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            res = res.concat(strs[i]);
        }
        // 如果等于0；
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        if (i == res.length()) {
            return "0";
        }
        return res.substring(i, res.length());
    }
}