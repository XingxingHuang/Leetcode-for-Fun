public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        // please modify the code with a faster one
        if (str.length() == 1) return false;
        for (int i = 0; i <= str.length() / 2 - 1; i ++) {
            boolean sign = true;
            // System.out.printf("%d %s\n", i, str.charAt(i)); 
            if (str.length() % (i+1) != 0) {
                //System.out.printf("%s",str.charAt(i)); 
                sign = false;
                continue;
            }
            for (int j = i + 1; j < str.length(); j ++){
                 int index = (j + 1) % (i + 1) - 1;
                 if (index == -1) index = i;
                 // System.out.printf("step2:%d %d %s\n", j, index, str.charAt(j)); 
                 if (str.charAt(j) != str.charAt(index) ) {
                     sign = false;
                 }
            }
            if (sign == true) {
                // System.out.printf("True"); 
                return true;
            }
        }
        return false;
    }
}

// 
public boolean repeatedSubstringPattern(String str) {
    int l = str.length();
    for(int i=l/2;i>=1;i--) {
        if(l%i==0) {
            int m = l/i;
            String subS = str.substring(0,i);
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<m;j++) {
                sb.append(subS);
            }
            if(sb.toString().equals(str)) return true;
        }
    }
    return false;
}