// 09.15
// check the discussion for a good visualization.
// https://discuss.leetcode.com/topic/50885/simple-java-o-klogk-solution-with-explanation
// step1. 新建一个堆，把每一个nums1中的元素加上nums2中的第一个元素，放入小根堆中
// step2. 每次取出一个最小的值的时候就再放入一个，（num1中的数字不变，num2后移一个）
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> (n1[0] + n1[1] - n2[0] - n2[1]));
        // put k pair into pq
        for (int i = 0; i < nums1.length && i < k; i++) 
            q.offer(new int[]{nums1[i], nums2[0], 0});
        // put another k pair into pq
        while (k > 0 && !q.isEmpty()) {
            k--;
            int[] cur = q.poll();
            res.add(new int[]{cur[0],cur[1]});
            if (cur[2] == nums2.length - 1)
                continue;
            q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}

//  一般遇到最大的k的问题，请用最大堆解决
// 时间复杂度高一点，程序思路更简洁。  每次添加两个新的pair到pq中
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        int[][] sign = new int[nums1.length][nums2.length];
        int i = 0; 
        int j = 0;
        q.add(new int[] {i, j});
        sign[i][j] = 1;
        while (!q.isEmpty() && k-- > 0) {
            int[] cur = q.poll();
            // System.out.println(i + " " + j);
            i = cur[0];
            j = cur[1];
            res.add(new int[]{nums1[i], nums2[j]});
            if (i + 1 < nums1.length && sign[i + 1][j] == 0) {
                q.add(new int[]{i + 1, j});
                sign[i + 1][j] = 1;
            }
            if (j + 1 < nums2.length && sign[i][j + 1] == 0) {
                q.add(new int[]{i, j + 1});
                sign[i][j + 1] = 1;
            }
        }
        return res;
    }
}