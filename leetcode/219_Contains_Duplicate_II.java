public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i]))  <= k) {
                    return true;
                } 
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

// // time out 
// public class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         if (nums == null || nums.length == 0 || k < 1) {
//             return false;
//         }
//         for (int i = 0; i < Math.min(i + k + 1, nums.length); i ++ ) {
//             for (int j = i + 1; j < Math.min(i + k + 1, nums.length); j ++) {
//                 if (nums[j] == nums[i]) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }