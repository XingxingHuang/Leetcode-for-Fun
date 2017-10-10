// 10.10 
// array
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0; 
        while (n > 0) {
            // out of bound
            if (i >= flowerbed.length) 
                return false;
            // move to the next 0 and two sides are 0
            while (i < flowerbed.length && 
                   (flowerbed[i] != 0 || 
                   (i + 1 < flowerbed.length && flowerbed[i + 1] != 0) ||
                   (i - 1 >= 0 && flowerbed[i - 1] != 0) ))
                i++;
            if (i == flowerbed.length)
                break;
            n--;
            flowerbed[i] = 1;
        }
        return n == 0;
    }
}


public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
}



public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
             if(count>=n)
                return true;
            i++;
        }
        return false;
    }
}