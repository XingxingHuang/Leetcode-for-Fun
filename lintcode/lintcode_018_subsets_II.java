/*
    @Author: Xingxing Huang
    @Date: 2017/03/27
    @递归标准: http://www.lintcode.com/en/problem/subsets-ii/
*/
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
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
            // 如果循环发现了重复的值，那么就不考虑。
            // 因为在下面的递归中已经添加过出现重复数值的情况。
            // 如果有重复数值，那么一定是从第一个数字开始取。即取后面必取前面数
            // 注意这里，重复数字是在递归中取得。再一次循环中只取了一次数字。
            if (i != idx && i < nums.length && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}