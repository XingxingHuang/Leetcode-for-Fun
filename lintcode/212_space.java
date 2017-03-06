// @Author Xingxing Huang
// O(n2)
public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                for (int j = length + 2; j > i + 2; j--) {
                    string[j] = string[j - 2];
                }
                string[i + 2] = '0';
                string[i + 1] = '2';
                string[i] = '%';
                length = length + 2;
            }
        }
        return length;
    }
}