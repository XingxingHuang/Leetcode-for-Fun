//12.30 
class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (; V > 0; V--) {
            int minLeft = K;
            for (int i = K - 1; i >= 0; i--) {
                if (heights[i] < heights[minLeft])
                    minLeft = i;
                if (heights[i] > heights[minLeft])
                    break;
            }
            if (minLeft < K) {
                heights[minLeft]++;
            } else {
                int minRight = K;
                for (int i = K + 1; i < heights.length; i++) {
                    if (heights[i] < heights[minRight])
                        minRight = i;
                    if (heights[i] > heights[minRight])
                        break;
                }
                heights[minRight]++;
            }
        }
        return heights;
    }
}


class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
    
        int n = heights.length;
        for (int i = 0;i < V;i ++) {
            int index = K;
            heights[index] ++;
            while (true) {
                heights[index] --;
                // check left
                int left = index - 1;
                while (left >= 0 && heights[left] == heights[index]) {
                    left --;
                }
                if (left >= 0) {
                    if (heights[left] < heights[index]) {
                        heights[left] ++;
                        index = left;
                        continue;
                    }
                }
                int right = index + 1;
                while (right < n && heights[right] == heights[index]) {
                    right ++;
                }
                if (right < n) {
                    if (heights[right] < heights[index]) {
                        heights[right] ++;
                        index = right;
                        continue;
                    }
                }
                heights[index] ++;
                break;
            }
        }
        return heights;
        
    }
}
