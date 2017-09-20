// 2017.08.08 XingxingHuang
// All the scores of athletes are guaranteed to be **unique**.
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (-nums[i] + nums[j]));
        for (int i = 0; i < nums.length; i++) 
            pq.offer(i);
        String[] res = new String[nums.length];
        if (!pq.isEmpty()) 
            res[pq.poll()] = "Gold Medal";
        if (!pq.isEmpty()) 
            res[pq.poll()] = "Silver Medal";
        if (!pq.isEmpty()) 
            res[pq.poll()] = "Bronze Medal";
        for (int i = 4; i <= nums.length; i++) {
            res[pq.poll()] = String.valueOf(i); 
        }
        return res;
    }
}