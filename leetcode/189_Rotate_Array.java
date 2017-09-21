// simple brute force method O(n) with O(n)
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] results = new int[len];
        for (int i = 0; i < len; i++) {
            if ( i - k % len >= 0) {
                results[i] = nums[i - k % len];
            } else {
                results[i] = nums[len - k % len + i];
            }
        }
        for (int i = 0; i < len; i++) {nums[i] = results[i];}
    }
}

// move one element each time O(m*n) with O(1)

// reverse and reverse method O(n) with O(1)
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


// ( Interesting way, O(n) time cost, O(1) space cost)
// https://discuss.leetcode.com/topic/11349/my-three-way-to-solve-this-problem-the-first-way-is-interesting-java
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;
        
        //gcd path to finish movie
        for(int i = 0; i < gcd; i++){
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for(int j = 0; j < count; j++){
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }
    
    public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }
    
}