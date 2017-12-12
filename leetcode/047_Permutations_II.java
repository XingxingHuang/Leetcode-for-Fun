// 12.12
// must practice 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        search(nums, list, new ArrayList<Integer>(), new boolean[nums.length]);
        return list;
    }
    private void search(int[] nums, List<List<Integer>> list, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            list.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++){
            // 存在重复数字的时候，有可能先取前面数字再去后面，或者反之。因此添加后面元素的时候前面元素必须已经used
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            used[i] = true;
            cur.add(nums[i]);
            search(nums, list, cur, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true; 
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}