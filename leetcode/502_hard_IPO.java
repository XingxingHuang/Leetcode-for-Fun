// at most k *distinct* project, only *initial* W capital. 
// Each project have a pure profit and minimum capital limit.
// condition: profits are non-negative integers ---> each time I should find the maximum profit and also maximize my capital.
// 2017.08.06 XingxingHuang
//
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (Capital.length <= k) {
            for (int i = 0; i < Capital.length; i++) 
                W += Profits[i];
            return W;
        }
        PriorityQueue<Integer> pq_cap = new PriorityQueue<>((i, j) -> (Capital[i] - Capital[j])); // min heap
        PriorityQueue<Integer> pq_pro = new PriorityQueue<>((i, j) -> (- Profits[i] + Profits[j])); // max heap
        
        for (int i = 0; i < Capital.length; i++) {
            pq_cap.add(i);
        }
        for (int i = 0; i < k; i++) {
            while (pq_cap.size() != 0 && Capital[pq_cap.peek()] <= W) {
                pq_pro.add(pq_cap.poll());
            }
            if (pq_pro.size() == 0) 
                break;
            W += Profits[pq_pro.poll()];
        }
        return W;
    }
}

// // 这里我每次选择了最大Capital的profit，结果是错误的。
// public class Solution {
//     public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//         if (Capital.length <= k) {
//             for (int i = 0; i < Capital.length; i++) 
//                 W += Profits[i];
//             return W;
//         }
        
//         HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
//         for (int i = 0; i < Capital.length; i++) {
//             if (!map.containsKey(Capital[i])) 
//                 map.put(Capital[i], new PriorityQueue<>((m, n) -> (-Profits[m] + Profits[n]))); // max heap
//             map.get(Capital[i]).add(i);
//         }
        
//         for (int i = 0; i < k; i++) {
//             int idx = -1;
//             for (int j = W; j >= 0; j--) if (map.containsKey(j)){
//                 idx = map.get(j).poll();
//                 if (map.get(j).size() == 0) map.remove(j);
//                 break;
//             }
//             if (idx != -1) {
//                 W += Profits[idx];
//                 //System.out.println(w + " " + Capital[idx]+ " " +Profits[idx]);
//             }
//         }
//         return W;
//     }
// }