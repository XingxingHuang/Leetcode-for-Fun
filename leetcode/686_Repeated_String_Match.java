// Time: O(N∗(N+M))
// Space: O(M+N)
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }
}




// cheating method. Using indexOf
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.isEmpty()) {
            return B.isEmpty()? 1:-1;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 2*B.length()) {
            sb.append(A);
        }
        int idx = sb.toString().indexOf(B);
        if (idx < 0) {
            return -1;
        } else {
            return (idx+B.length()+A.length()-1)/A.length();
        }
    }
}


// my contest solution 
// 从每个相同的元素开始往后开始比较，查看是否能组成B
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A == null) return -1;
        if (A.length() == 0 && B.length() != 0) return -1;
        if (B == null || B.length() == 0) return 1;
        if (A.length() == 0) return -1;
        
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0))  {
                int count = check(A, B, i, 0);
                if (count > 0) return count;
            }
        }
        return -1;
    }
    private int check(String A, String B, int idx1, int idx2) {
        int i = idx2;
        int j = idx1;
        int count = j == 0 ? 0 : 1;
        while (i < B.length() && A.charAt(j % A.length()) == B.charAt(i)) {
            if (j % A.length() == 0) count++;
            i++;
            j++;
        }
        if (i == B.length()) return count;
        return -1;
                
    }
}




// linear time complexity, check the hashcode
import java.math.BigInteger;

class Solution {
    public boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public int repeatedStringMatch(String A, String B) {
        int q = (B.length() - 1) / A.length() + 1;
        int p = 113, MOD = 1_000_000_007;
        int pInv = BigInteger.valueOf(p).modInverse(BigInteger.valueOf(MOD)).intValue();

        long bHash = 0, power = 1;
        for (int i = 0; i < B.length(); i++) {
            bHash += power * B.codePointAt(i);
            bHash %= MOD;
            power = (power * p) % MOD;
        }

        long aHash = 0; power = 1;
        for (int i = 0; i < B.length(); i++) {
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            power = (power * p) % MOD;
        }

        if (aHash == bHash && check(0, A, B)) return q;
        power = (power * pInv) % MOD;

        for (int i = B.length(); i < (q + 1) * A.length(); i++) {
            aHash -= A.codePointAt((i - B.length()) % A.length());
            aHash *= pInv;
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            if (aHash == bHash && check(i - B.length() + 1, A, B)) {
                return i < q * A.length() ? q : q + 1;
            }
        }
        return -1;
    }
}