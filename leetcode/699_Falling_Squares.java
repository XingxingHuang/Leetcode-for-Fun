// //  time exceed
// class Solution {
//     public List<Integer> fallingSquares(int[][] positions) {
//         List<Integer> res = new ArrayList<>();
//         if (positions == null || positions.length == 0) 
//             return res;
//         List<Integer> stick = new ArrayList<>();
//         int max = 0;
//         int left = positions[0][0];
//         for (int i = 0; i < positions.length; i++) {
//             left = Math.min(left, positions[i][0]);
//         }
//         for (int i = 0; i < positions.length; i++) {
//             int[] position = positions[i];
//             // // left
//             // if (position[0] < left) {
//             //     for (int k = 0; k < left - position[0]; k++)
//             //         stick.add(0, 0);
//             //     left = position[0];
//             // }
//             // check the length
//             int size = stick.size();
//             // check the max height
//             int l = position[0] - left;
//             int r = position[0] - left + position[1] - 1;
//             int height = 0;
//             for (int k = l; k <= r && k < stick.size(); k++) {
//                 height = Math.max(stick.get(k), height);
//             }
//             // change the height
//             height += position[1];
//             for (int k = l; k <= r; k++) {
//                 if (k >= stick.size()) {
//                     stick.add(height);
//                 } else {
//                     stick.set(k, height);
//                 }
//             }
//             // check current max height
//             max = Math.max(max, height);
//             res.add(max);
//         }
//         return res;
//     }
// }

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        for (int[] build: buildings) {
            height.add(new int[]{build[0], -build[2]});
            height.add(new int[]{build[1], build[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // smaller x first
            return a[1] - b[1]; // same x, then smaller height first, 
        });
        // 
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
    }
}