// 12.12 
// 经典backtrack 练手题
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        search(res, n, 1, new ArrayList<Integer>(), k);
        return res;
    }
    private void search(List<List<Integer>> res, int n, int idx, List<Integer> cur, int k) {
        if (cur.size() == k)
            res.add(new ArrayList<Integer>(cur));
        for (int i = idx; i <= n; i++) {
            cur.add(i);
            search(res, n, i + 1, cur, k);
            cur.remove(cur.size() - 1);
        }
    }
}