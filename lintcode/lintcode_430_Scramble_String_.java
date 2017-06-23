// http://www.lintcode.com/en/problem/scramble-string/
// 九章答案
// http://www.jiuzhang.com/solution/scramble-string/
// 中文解题报告：暴力>剪枝>记忆化搜索>动态规划

// 记忆化搜索
public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
    
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length())
            return false;
            
        if (hash.containsKey(s1 + "#" + s2))
            return hash.get(s1 + "#" + s2);
        
        int n = s1.length();
        if (n == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        // 采用hashmap记录计算过的内容，完成记忆化搜索
        for (int k = 1; k < n; ++k) {
            if (isScramble(s1.substring(0, k), s2.substring(0, k)) &&
                isScramble(s1.substring(k, n), s2.substring(k, n)) ||
                isScramble(s1.substring(0, k), s2.substring(n - k, n)) &&
                isScramble(s1.substring(k, n), s2.substring(0, n - k))
                ) {
                hash.put(s1 + "#" + s2, true);
                return true;
            }
        }
        hash.put(s1 + "#" + s2, false);
        return false;
    }
}

// 递推
public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length())
            return false;
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            
        for (int len = 2; len <= n; ++len)
            for (int x = 0; x < n && x + len <= n; ++x)
                for (int y = 0; y < n && y + len <=n; ++y)
                    for (int k= 1; k < len; ++k)
                    dp[x][y][len] |= dp[x][y][k] && dp[x + k][y + k][len - k]
                    || dp[x][y + len - k][k] && dp[x + k][y][len - k];
    
        return dp[0][0][n];
    }
}



// 普通搜索
public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        
        if (!isValid(s1, s2)) {
            return false;
        }// Base Cases
        
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());
            
            if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
            if (isScramble(s11, s24) && isScramble(s12, s23)) return true;// cut 
            
        }
        return false;
    }
    
    
    private boolean isValid(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!(new String(arr1)).equals(new String(arr2))) {
            return false;
        }
        return true;
    }
}

// 记忆化搜索
public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
     
     private boolean checkScramble(String s1,int start1, String s2, int start2, int k, int [][][]visit) {
        if(visit[start1][start2][k] == 1)
            return true;
        if(visit[start1][start2][k] ==-1)
            return false;
        
        
        if (s1.length() != s2.length()) {
            visit[start1][start2][k] = -1;
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            visit[start1][start2][k] = 1;
            return true;
        }
        
        if (!isValid(s1, s2)) {
            visit[start1][start2][k] = -1;
            return false;
        }// Base Cases
        
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());
            
            if (checkScramble(s11,start1, s21, start2, i, visit) && checkScramble(s12, start1+i, s22, start2+i,k-i, visit))  {
                visit[start1][start2][k] = 1;
                return true;
            }
            
            if (checkScramble(s11,start1, s24, start2+k-i, i, visit) && checkScramble(s12,start1+i, s23,start2, k-i, visit))
            {
                visit[start1][start2][k] = 1;
                return true;
            }
        }
        visit[start1][start2][k] = -1;
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int [][][] visit = new int[len][len][len + 1];
        return checkScramble(s1,0,s2,0, len, visit);
    }
    
    
    private boolean isValid(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!(new String(arr1)).equals(new String(arr2))) {
            return false;
        }
        return true;
    }
}