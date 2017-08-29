// 2017.08.26  XingxingHuang
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int tmp = twoSum(nums, target - nums[i], i + 1, nums.length - 1);
            if (Math.abs(tmp) < Math.abs(ans)) 
                ans = tmp;
        }
        return target - ans;
    }
    private int twoSum(int[] nums, int target, int i, int j) {
        int ans = Integer.MAX_VALUE;
        while (i < j) {
            int tmp = target - nums[i] - nums[j];
            if (tmp == 0)
                return 0;
            if (Math.abs(tmp) < Math.abs(ans)) 
                ans = tmp;
            if (tmp > 0) 
                i++;
            else
                j--;
        }
        return ans;
    }
}


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}