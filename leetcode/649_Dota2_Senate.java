// 2017.07.29 contest 
// 每个人的策略就是如果下一个人不是自己的队伍，那么就必须ban，最后只剩下一个队伍的时候就知道谁胜负了。
public class Solution {
    public String predictPartyVictory(String senate) {
        // 检查每个队伍的数目
        int n = senate.length(), rCount = (int) senate.chars().filter(c -> c == 'R').count();
        int[] count = new int[]{rCount, n - rCount};
        boolean[] banned = new boolean[n];

        while (count[0] > 0 && count[1] > 0) {
            int[] banCount = new int[2];
            for (int i = 0; i < 2 * n; i++) { // 循环到2n，保证收尾的元素
                // 已经banned，跳过
                if (banned[i % n]) 
                    continue;
                // 队伍是 R 还是 D
                int idx = senate.charAt(i % n) == 'R' ? 0 : 1;
                // 该位置是否会被ban
                if (banCount[idx] > 0) {
                    banCount[idx]--;
                    count[idx]--;
                    banned[i % n] = true;
                } else if (i < n) {
                    banCount[-idx + 1]++;
                }
            }
        }
        return count[0] > 0 ? "Radiant" : "Dire";
    }
}


public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        // store the index;
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                q1.offer(i);
            } else {
                q2.offer(i);
            }
        }
        // loop
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int i1 = q1.poll();
            int i2 = q2.poll();
            if (i1 < i2) {
                q1.offer(i1 + n);
            } else {
                q2.offer(i2 + n);
            }
        }
        return q1.size() > q2.size() ? "Radiant" : "Dire";
    }
}