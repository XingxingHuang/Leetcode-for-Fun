// 2017.08.30 XingxingHuang
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int count = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j]) && map.get(list2[j]) + j <= count) {
                if (map.get(list2[j]) + j < count) {
                    res = new ArrayList<>();
                    count = map.get(list2[j]) + j;
                }
                res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}


// solution:
// https://leetcode.com/problems/minimum-index-sum-of-two-lists/solution/
// Approach #1 Using HashMap [Accepted]
// Approach #2 Without Using HashMap [Accepted]
// Approach #3 Using HashMap (linear) [Accepted]