class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return false;
        if (k == 1) return true;
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % k != 0) return false;
        int subsum = sum / k;
        // start
        int[] subsetSum = new int[k];
        boolean[] visit = new boolean[nums.length];
        // put one value first
        subsetSum[0] = nums[nums.length - 1];
        visit[nums.length - 1] = true;
        return check(nums, subsetSum, visit, subsum, k, nums.length, 0, nums.length - 1);
    }
    private boolean check(int[] nums, int[] subsetSum, boolean[] visit, int sum, int k, int N, int cur, int limit) {
        if (subsetSum[cur] == sum) {
            if (cur == k - 2) return true;
            return check(nums, subsetSum, visit, sum, k, N, cur+1, N - 1);
        } 
        for (int i = limit; i >= 0; i--) {
            if (visit[i]) continue;
            int tmp = subsetSum[cur] + nums[i];
            if (tmp <= sum) {
                visit[i] = true;
                subsetSum[cur] += nums[i];
                boolean next = check(nums, subsetSum, visit, sum, k, N, cur, i - 1);
                visit[i] = false;
                subsetSum[cur] -= nums[i];
                if (next) return true;
            }
        }
        return false;
    }
}