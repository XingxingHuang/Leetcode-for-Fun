public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        while (i <= j) {
            while (i <= j && nums[j] == val) j--;
            while (i <= j && nums[i] != val) i++;
            if (i < j) {
                nums[i] = nums[j];
                nums[j] = val;
            }    
        }
        //if (j == -1) return 0;
        return j + 1;
        
    }
}


public int removeElement(int[] A, int elem) {
   int m = 0;    
   for(int i = 0; i < A.length; i++){
       
       if(A[i] != elem){
           A[m] = A[i];
           m++;
       }
   }
   
   return m;
}