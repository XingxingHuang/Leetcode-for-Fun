//  11.16
// attention for the anchor, 

class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) 
            return 0;
        char c = chars[0];
        int start = 0; // the start point
        int idx = 0;  // the index to store the number
        while (start < chars.length) {
            int end = start;
            int count = 0; // the number of same characters
            char target = chars[start];
            while (end < chars.length && chars[end] == target) {
                // count the characters
                count++;
                end++;
            }
            start = end;
            // modify the array
            if (count == 1) {
                chars[idx] = target;
                idx++;
            } else if (count < 10) {
                chars[idx] = target;
                chars[++idx] = Character.forDigit(count, 10);
                idx++;
            } else if (count < 100) {
                chars[idx] = target;
                chars[idx + 2] = Character.forDigit(count%10, 10);
                chars[idx + 1] = Character.forDigit((count/10)%10, 10);
                idx += 3;
            } else {
                chars[idx] = target;
                chars[idx + 3] = Character.forDigit(count%10, 10);
                chars[idx + 2] = Character.forDigit((count/10)%10, 10);
                chars[idx + 1] = Character.forDigit((count/100)%10, 10);
                idx += 4;                
            }        
        }
        return idx;
    }
}

class Solution {
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}