// 2017.07.31
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) 
            return 0;
        int total = 0;
        int cur = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] >= cur + duration) {
                total += duration;
            } else {
                total += timeSeries[i] - cur;
            }
            cur = timeSeries[i];
        }
        total += duration;
        return total;
    }
}