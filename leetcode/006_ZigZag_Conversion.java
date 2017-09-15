// 09.15
// n = numRows
// Δ = 2n-2    1                           2n-1                         4n-3
// Δ =         2                     2n-2  2n                    4n-4   4n-2
// Δ =         3               2n-3        2n+1              4n-5       .
// Δ =         .           .               .               .            .
// Δ =         .       n+2                 .           3n               .
// Δ =         n-1 n+1                     3n-3    3n-1                 5n-5
// Δ = 2n-2    n                           3n-2                         5n-4

class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) 
            sb[i] = new StringBuilder();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx  < numRows && i < len; idx++)
                sb[idx].append(c[i++]);
            for (int idx = numRows - 2; idx >=1 && i < len; idx--) 
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++) 
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}