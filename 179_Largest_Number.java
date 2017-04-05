/** @Author: Xingxing Huang
 *  @Date: 2017.04.05
 *  @Time: O(nk,log nk), the sort method.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        // 对数组进行排序，前面大得排序在前面
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        // Arrays.sort(str, (a, b) -> ((b+a).compareTo(a+b)));
        // 找到最大的第一位还是0，说明数字为0
        if (str[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s: str) {
            sb.append(s);
        }
        return sb.toString();
    }
}