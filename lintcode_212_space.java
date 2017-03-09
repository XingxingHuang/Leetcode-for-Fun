// @Author Xingxing Huang
// O(n)
public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (string == null || string.length < length) {
            return -1;
        }
        int blank = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                blank++;
            }
        }
        int newlength = length + blank * 2;
        for (int i = length - 1; i >= 0; i--) {
            int j = i + blank * 2;
            if (string[i] == ' ') {
                blank--;
                string[j] = '0';
                string[j - 1] = '2';
                string[j - 2] = '%';
            } else {
                string[j] = string[i];
            }
        }
        return newlength;
    }
}

// // @Author Xingxing Huang
// // O(n2)
// public class Solution {
//     /**
//      * @param string: An array of Char
//      * @param length: The true length of the string
//      * @return: The true length of new string
//      */
//     public int replaceBlank(char[] string, int length) {
//         // Write your code here
//         for (int i = 0; i < length; i++) {
//             if (string[i] == ' ') {
//                 for (int j = length + 2; j > i + 2; j--) {
//                     string[j] = string[j - 2];
//                 }
//                 string[i + 2] = '0';
//                 string[i + 1] = '2';
//                 string[i] = '%';
//                 length = length + 2;
//             }
//         }
//         return length;
//     }
// }