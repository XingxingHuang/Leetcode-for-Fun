// 2017.07.26
public class Solution {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (chars[n - 2 - i] < chars[n - 1 - i]) {
                int index = n - 2 - i;
                break;
            }
            if (i == n - 2)  
                return -1;
        }
        int index_small = Integer.MAX_VALUE;
        for (int j = index; j >= 0; j--) {
            if (chars[j] > chars[i]) {
                int index_small = j;
                break;
            }
        }
        if (index_small == Integer.MAX_VALUE) {
            return -1;
        }
        swap(chars, index, index_small);
        return Ingeter.valueOf(Character.toString(chars));
    }
    private void swap(int nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// // https://leetcode.com/problems/next-greater-element-iii/#/discuss
// public class Solution {
//     public int nextGreaterElement(int n) {
//         char[] number = (n + "").toCharArray();
        
//         int i, j;
//         // I) Start from the right most digit and 
//         // find the first digit that is
//         // smaller than the digit next to it.
//         for (i = number.length-1; i > 0; i--)
//             if (number[i-1] < number[i])
//                break;

//         // If no such digit is found, its the edge case 1.
//         if (i == 0)
//             return -1;
            
//          // II) Find the smallest digit on right side of (i-1)'th 
//          // digit that is greater than number[i-1]
//         int x = number[i-1], smallest = i;
//         for (j = i+1; j < number.length; j++)
//             if (number[j] > x && number[j] <= number[smallest])
//                 smallest = j;
        
//         // III) Swap the above found smallest digit with 
//         // number[i-1]
//         char temp = number[i-1];
//         number[i-1] = number[smallest];
//         number[smallest] = temp;
        
//         // IV) Sort the digits after (i-1) in ascending order
//         Arrays.sort(number, i, number.length);
        
//         long val = Long.parseLong(new String(number));
//         return (val <= Integer.MAX_VALUE) ? (int) val : -1;
//     }
// }