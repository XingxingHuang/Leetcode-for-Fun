// bit wise method
public class Solution {
    public int singleNumber(int[] nums) {
        int results = 0;
        for (int i:nums){
            results ^=i;
        }
        return(results);
        
    }
}