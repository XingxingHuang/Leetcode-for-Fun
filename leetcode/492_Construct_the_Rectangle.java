// 2017.07.29
public class Solution {
    public int[] constructRectangle(int area) {
        if (area == 0) 
            return new int[] {0, 0};
        for (int i = (int) Math.sqrt(area); i <= area; i++) {
            if (area % i == 0 && i >= area / i) 
                return new int[]{i, area / i};
        }
        return new int[]{1, area};
    }
}

public class Solution {
    public int[] constructRectangle(int area) {
            int w = (int) Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }
}