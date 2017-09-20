//2017.08.27 XingxingHuang
// easy, two loop 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        res.add(new ArrayList<Integer>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            res.add(new ArrayList<Integer>());
            res.get(i).add(1);
            for (int j = 0; j < res.get(i - 1).size() - 1; j++) 
                res.get(i).add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            res.get(i).add(1);
        }
        return res;
    }
}