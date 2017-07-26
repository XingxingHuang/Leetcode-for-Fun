/**
 * 很容易想到先排序再分析，但是注意可以用桶排序。
 * @author  Xingxing Huang  
 * @since   2017.05.23  
 * @Time    O(n)    
 * @param   int[]
 * @return  int
 */

//普通排序算法；
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length) {
            if (i + 1 > citations[citations.length - i - 1]) {
                break;
            }
            i++;
        }
        return i;
    }
}

// 桶排序
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] bucket = new int[len + 1];
        
        // 如果引用数目大于文章数，那么肯定贡献H Index。
        for (int i = 0; i < len; i++) {
            if (citations[i] > len) {
                bucket[len]++;
            } else {
                bucket[citations[i]]++;
            }
        }
        // 坐标i为引用次数。total为总的文章数目。
        int total = 0;
        for(int i = len; i >=0; i--) {
            total = total + bucket[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}