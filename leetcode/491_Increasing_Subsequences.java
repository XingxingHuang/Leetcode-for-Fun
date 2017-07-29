/**
 * 典型题，subset题看了之后即可。注意去重
 * @author  Xingxing Huang  
 * @since   2017.05.11
 * @Time    O(n)    
 * @param   int[]
 * @return  List<List<Integer>>
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // init and corner case
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(res);
        }  
        // dfs
        dfs(nums, 0, res, new ArrayList<Integer>());
        return new ArrayList<>(res);
    }
    public void dfs(int[] nums, int n, Set<List<Integer>> res, List<Integer> subset) {
        List<Integer> list = new ArrayList<Integer>(subset);
        if (list.size() >= 2) {
            res.add(list);
        }
        for (int i = n; i < nums.length; i++) {
            if (subset.size() == 0 || nums[i] >= subset.get(subset.size() - 1)) {
                subset.add(nums[i]);
                dfs(nums, i + 1, res, subset);
                subset.remove(subset.size() - 1);
            }
        }
    }
}

// 先放入一个元素，然后DFS
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // init and corner case
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(res);
        }  
        // dfs, 先放入一个首元素
        for (int i = 0; i < nums.length; i++) {
            List<Integer> subset = new ArrayList<Integer>();
            subset.add(nums[i]);
            dfs(nums, i + 1, res, subset);
        }
        return new ArrayList<>(res);
    }
    public void dfs(int[] nums, int n, Set<List<Integer>> res, List<Integer> subset) {
        List<Integer> list = new ArrayList<Integer>(subset);
        if (list.size() >= 2) {
            res.add(list);
        }
        for (int i = n; i < nums.length; i++) {
            if (nums[i] >= subset.get(subset.size() - 1)) {
                subset.add(nums[i]);
                dfs(nums, i + 1, res, subset);
                subset.remove(subset.size() - 1);
            }
        }
    }
}