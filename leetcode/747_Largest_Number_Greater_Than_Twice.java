//12.23
// easy 难度
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) 
            return -1;
        if (nums.length == 1) 
            return 0;
        int idxmax = 0;
        int maxvalue = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[idxmax]) {
                maxvalue = Math.max(maxvalue, 2 * nums[i]);
            } else {
                maxvalue = 2 * nums[idxmax];
                idxmax = i;
            }
        }
        // System.out.println(idxmax);
        if (nums[idxmax] >= maxvalue)
            return idxmax;
        return -1;
    }
}


class Solution {
  public int dominantIndex(int[] nums) {
     
        int i , j , n = nums.length;
        int max = nums[0] , index = 0;
        for (i = 0;i < n;i ++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (i = 0;i < n;i ++) {
            if (i != index) {
                if (nums[index] >= nums[i] * 2) {
                    continue;
                } else {
                    return - 1;
                }
            }
        }
        return index;
        
    }
}