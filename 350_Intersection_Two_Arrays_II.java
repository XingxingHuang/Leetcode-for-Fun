/**
 * @Athor: Xingxing Huang
 * @Date: 2017.04.13
 * @Time: O(n), 请考虑题目的following up question
 */
 
 public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 0);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                res.add(nums2[i]);
                if (map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}