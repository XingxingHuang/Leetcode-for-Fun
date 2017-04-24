public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle ==  null) {
            return Integer.MAX_VALUE;
        }
        int n = triangle.size();
        int[] res = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}