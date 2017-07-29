public class Solution {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int index = 0;
        int m = chars.length;
        int i = 0;
        for (i = 0; i < m - 1; i++) {
            if (chars[m - 2 - i] < chars[m - 1 - i]) {
                index = m - 2 - i;
                break;
            }
        }
        if (i == m - 1)  // desc sequence
            return -1;
        int index_small = index + 1;
        for (int j = index + 1; j < m; j++) {
            if (chars[j] > chars[index] && chars[j] <= chars[index_small]) {
                index_small = j;
            }
        }
        swap(chars, index, index_small);
        Arrays.sort(chars, index_small + 1, m);  // sort 
        //return Integer.valueOf(String.valueOf(chars));
        long val = Long.parseLong(new String(chars));
        return val >= Integer.MAX_VALUE ? -1 : (int) val;
    }
    private void swap(char[] nums, int i , int j) {
        char temp = nums[i];
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