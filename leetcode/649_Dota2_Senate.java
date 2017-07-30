// 2017.07.29 contest 
public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length(), rCount = (int) senate.chars().filter(c -> c == 'R').count();
        int[] count = new int[]{rCount, n - rCount};
        boolean[] banned = new boolean[n];

        while (count[0] > 0 && count[1] > 0) {
            int[] banCount = new int[2];
            for (int i=0;i<2*n;i++) {
                if (banned[i % n]) continue;
                int idx = senate.charAt(i % n) == 'R' ? 0 : 1;
                if (banCount[idx] > 0) {
                    banCount[idx]--;
                    count[idx]--;
                    banned[i % n] = true;
                }
                else if (i < n) banCount[-idx + 1]++;
            }
        }

        return count[0] > 0 ? "Radiant" : "Dire";
    }
}