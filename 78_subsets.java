// http://www.jiuzhang.com/solutions/subsets/
// refer http://www.cnblogs.com/yuzhangcmu/p/4211815.html


// Non Recursion
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        
        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]
        // 总共有2^n 的排列组合。
        // 第一重循环，每次添加一种组合。
        // 第二重循环，每次查看哪一位上需要放入
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0) {  //如果该位上为1，那么就加上
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
}