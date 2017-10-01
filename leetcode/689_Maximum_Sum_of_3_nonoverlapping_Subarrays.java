// O(n)  https://leetcode.com/articles/maximum-sum-of-3-non-overlapping-intervals/
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        //W is an array of sums of windows
        int[] W = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K) sum -= nums[i-K];
            if (i >= K-1) W[i-K+1] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        for (int j = K; j < W.length - K; j++) {
            int i = left[j - K], k = right[j + K];
            if (ans[0] == -1 || W[i] + W[j] + W[k] >
                    W[ans[0]] + W[ans[1]] + W[ans[2]]) {

                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        return ans;
    }
}


// 超时
// 尝试转化成two sum，但是two sum的优化没成功
class Solution {
    private int max = Integer.MIN_VALUE;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || k <= 0 || 3 * k > nums.length) 
            return null;
        int[] res = new int[3];
        
        // get the list of sum
        int[] sums = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            sums[i - k + 1] = sums[i - k] + nums[i] - nums[i - k];
        }
        // slide windows
        int i = 0;
        while (i < sums.length - 2 * k) {
            int idx1 = i;
            // move the 2st and 3st index
            int[] two = maxTwo(sums, i + k, k);
            // move the first index
            int one = sums[idx1];
            if (two[0] > i + k) {
                for (int j = i + 1; j < two[0] - k; j++) {
                    if (one < sums[j]) {
                        one = sums[j];
                        idx1 = j;
                    }
                }
            }
            // check the 3sum
            if (sums[idx1] + sums[two[0]] + sums[two[1]] > max) {
                max = sums[idx1] + sums[two[0]] + sums[two[1]];
                res = new int[] {idx1, two[0], two[1]};
            }
            i = idx1 + 1;
        }
        return res;
    }
    // Time exceed: 
    private int[] maxTwo(int[] sums, int idx, int k) {
        int idx1 = idx;
        int idx2 = idx + k;
        for (int j = idx + k; j < sums.length; j++) {
            for (int i = idx; i <= j - k; i++) {
                if (sums[i] + sums[j] > sums[idx1] + sums[idx2]) {
                    idx1 = i;
                    idx2 = j;
                }
            }
        }
        return new int[] {idx1, idx2};
    }
}