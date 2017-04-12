/*
    @Author: Xingxing Huang
    @Date: 2017/03/27
    @递归标准
*/
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        //helper(nums, res, subset, idx);
        helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
    private void helper(int[] nums,
                        ArrayList<ArrayList<Integer>> res,
                        ArrayList<Integer> subset,
                        int idx) {
        //res.add(subset);
        ArrayList<Integer> list = new ArrayList<Integer>(subset);
        res.add(list);
        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}