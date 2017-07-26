// 2017.07.18 重新练习
// @Xingxing Huang  
// 难点，区别next数组的指标和数值，否则容易出错。记录min,max的值；循环的时用一个flag判断是否达到数组末尾
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int m = nums.size();
        int[] next = new int[m];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                                            (i, j) -> nums.get(i).get(next[i]) - 
                                            nums.get(j).get(next[j]));
        // put first values of each list into pq
        int x = 0; // max
        int y = 0; // min
        for (int i = 0; i < m; i++) {
            pq.offer(i);
            if (nums.get(i).get(0) > nums.get(x).get(0)) 
                x = i;
            if (nums.get(i).get(0) < nums.get(y).get(0)) 
                y = i;
        }
        int min_global = nums.get(y).get(0);
        int max_global = nums.get(x).get(0);
        // loop for all values
        int max_new = max_global;
        int min_new = min_global;
        boolean finish_line = false;
        for (int i = 0; i < m && !finish_line; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {  
                int min_index = pq.poll();
                next[min_index]++;
                if (next[min_index] == nums.get(min_index).size()) {
                    finish_line = true;
                    break;
                }
                pq.offer(min_index);
                int new_y = pq.peek();
                max_new = Math.max(max_new, 
                                   nums.get(min_index).get(next[min_index]));
                min_new = nums.get(new_y).get(next[new_y]);
                if (max_new - min_new < max_global - min_global) {
                    min_global = min_new;
                    max_global = max_new;
                }
            }
        }
        return new int[] {min_global, max_global};
    }
}


// 注意使用PriorityQueue提升性能。
// 注意PQ中使用的是坐标，判断大小使用的是数组元素的值。
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int x = 0;
        int y = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];   // 每个数组中正在使用的元素的下标
        PriorityQueue<Integer> queue = new PriorityQueue<Integer> (
                (i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j])); // 获得最小的元素对应的下标
        
        boolean flag = true;    // 记录是否某一行已经扫描完毕
        for (int i = 0; i < nums.size(); i++) { //  初始化PQ
            queue.offer(i);
            y = Math.max(y, nums.get(i).get(0));
        }
        x = nums.get(queue.peek()).get(0);
        //
        int min = x;
        int max = y;
        for (int i = 0; i < nums.size() && flag; i++) { // 每次添加新的元素，查看是否有更好的区间。
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_i = queue.peek();
                if (next[min_i] + 1 < nums.get(min_i).size()) {
                    queue.poll();
                    next[min_i]++;
                    queue.offer(min_i); 
                    int min_j = queue.peek();
                    min = nums.get(min_j).get(next[min_j]);
                    max = Math.max(max, nums.get(min_i).get(next[min_i]));
                    if (y - x > max - min) {
                        x = min;
                        y = max;
                    }
                } else {
                    flag = false;
                    break;
                } 
            }
        }
        return new int[] {x, y};
    }
}

// 最佳解决方案
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] next = new int[nums.size()];        
        PriorityQueue<Integer> min_queue = new PriorityQueue<Integer> (
                    (i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            min_queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        
        int x = 0;
        int y = Integer.MAX_VALUE;
        boolean flag = true;
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {  // 这里的i，j只是保证遍历所有元素，并不直接使用。
                int min_i = min_queue.poll();
                if (y - x > max - nums.get(min_i).get(next[min_i])) {
                    x = nums.get(min_i).get(next[min_i]);
                    y = max;
                }
                next[min_i]++;
                if (next[min_i] == nums.get(min_i).size()) {  // 增加的结束条件
                    flag = false;
                    break;
                }
                min_queue.offer(min_i); // 更新min
                max = Math.max(max, nums.get(min_i).get(next[min_i])); // 更新max
            }
        }
        return new int[] {x, y};
    }
}
// 超时
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0;
        int miny = Integer.MAX_VALUE;
        int[] next = new int[nums.size()];  // 记录nums中的每个数组已经计算到了第几个元素。
        boolean flag = true;
        for (int i = 0; i < nums.size() && flag; i++) {   // 对每一个数组
            for (int j = 0; j < nums.get(i).size() && flag; j++) { // 数组中每一个元素
                int min = 0;
                int max = 0;
                // 加入这个元素，更新next数组的范围，
                for (int k = 0; k < nums.size(); k++) {
                    if (nums.get(min).get(next[min]) > nums.get(k).get(next[k])) 
                        min = k;
                    if (nums.get(max).get(next[max]) < nums.get(k).get(next[k])) 
                        max = k;
                }
                // 更新区间，如果新的结果区间小于[minx, miny]组成的值。
                if (miny - minx > nums.get(max).get(next[max]) - nums.get(min).get(next[min])) {
                    miny = nums.get(max).get(next[max]);
                    minx = nums.get(min).get(next[min]);
                }
                next[min]++; // 下一次取最小值的那个数组的下一个元素。
                // 当某一行已经检查到最后一个元素时，搜索提前结束
                if (next[min] == nums.get(min).size())  
                    flag = false;
            }
        }
        return new int[] {minx, miny};
    }
}


// // article: https://leetcode.com/articles/smallest-range/

// // pointer  O(n * m)
// public class Solution {
//     public int[] smallestRange(int[][] nums) {
//         int minx = 0, miny = Integer.MAX_VALUE;
//         int[] next = new int[nums.length];
//         boolean flag = true;
//         for (int i = 0; i < nums.length && flag; i++) {
//             for (int j = 0; j < nums[i].length && flag; j++) {
//                 int min_i = 0, max_i = 0;
//                 for (int k = 0; k < nums.length; k++) {
//                     if (nums[min_i][next[min_i]] > nums[k][next[k]])
//                         min_i = k;
//                     if (nums[max_i][next[max_i]] < nums[k][next[k]])
//                         max_i = k;
//                 }
//                 if (miny - minx > nums[max_i][next[max_i]] - nums[min_i][next[min_i]]) {
//                     miny = nums[max_i][next[max_i]];
//                     minx = nums[min_i][next[min_i]];
//                 }
//                 next[min_i]++;
//                 if (next[min_i] == nums[min_i].length) {
//                     flag = false;
//                 }
//             }
//         }
//         return new int[] {minx, miny};
//     }
// }

// // priority queue  O(n * log m)
// public class Solution {
//     public int[] smallestRange(int[][] nums) {
//         int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//         int[] next = new int[nums.length];
//         boolean flag = true;
//         PriorityQueue < Integer > min_queue = new PriorityQueue < Integer > ((i, j) -> nums[i][next[i]] - nums[j][next[j]]);
//         for (int i = 0; i < nums.length; i++) {
//             min_queue.offer(i);
//             max = Math.max(max, nums[i][0]);
//         }
//         for (int i = 0; i < nums.length && flag; i++) {
//             for (int j = 0; j < nums[i].length && flag; j++) {
//                 int min_i = min_queue.poll();
//                 if (miny - minx > max - nums[min_i][next[min_i]]) {
//                     minx = nums[min_i][next[min_i]];
//                     miny = max;
//                 }
//                 next[min_i]++;
//                 if (next[min_i] == nums[min_i].length) {
//                     flag = false;
//                     break;
//                 }
//                 min_queue.offer(min_i);
//                 max = Math.max(max, nums[min_i][next[min_i]]);
//             }
//         }
//         return new int[] { minx, miny};
//     }
// }