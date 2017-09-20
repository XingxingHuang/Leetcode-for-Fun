// 2017.09.06
public class Solution {
    public boolean makesquare(int[] nums){
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        
        return dfs(nums, sum/4, new int[4], nums.length - 1);
    }
    
    private boolean dfs(int[] nums, int target, int[] sum, int idx) {
        // end
        if (idx == 0)
            return sum[0] == target && sum[1] == target && sum[2] == target;
        // dfs
        for (int i = 0; i < 4; i++) {
            if (target - nums[idx] < sum[i]) continue;
            sum[i] += nums[idx];
            if (dfs(nums, target, sum, idx - 1)) return true;
            sum[i] -= nums[idx];
        }
        return false;
    }
}


// https://leetcode.com/problems/matchsticks-to-square/discuss/
// According to https://en.wikipedia.org/wiki/Partition_problem, the partition problem (or number partitioning) is the task of deciding whether a given multiset S of positive integers can be partitioned into two subsets S1 and S2 such that the sum of the numbers in S1 equals the sum of the numbers in S2. The partition problem is NP-complete.

public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        
        return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
            return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }
        
        return false;
    }
}




public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        
        Arrays.sort(nums);
        reverse(nums);
        
        return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
            return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }
        
        return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}

// https://discuss.leetcode.com/topic/72569/java-dfs-solution-with-various-optimizations-sorting-sequential-partition-dp