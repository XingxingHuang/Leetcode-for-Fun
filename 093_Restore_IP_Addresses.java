// recursive, DFS, 边界条件
// //  错误：  ‘010010’  按照题目意思不能分解成"10.0.1.0"
// public class Solution {
//     private HashSet<String> res = new HashSet<>();
//     public List<String> restoreIpAddresses(String s) {
//         helper(s, 0, new int[4], 0);
//         return new ArrayList<String>(res);
//     }
//     private void helper(String s, int idx, int[] nums, int n) {
//         if (n == 4 && idx == s.length()) {
//             String ips = ""+nums[0];
//             for (int i = 1; i < 4; i++) {
//                 ips = ips + "." + nums[i];
//             }
//             res.add(ips);
//         } else if (n >= 4 || idx >= s.length()) {
//             return;
//         }
//         for (int i = 1; i <= 3; i++) {
//             if (idx + i <= s.length()) { 
//                 int ip = Integer.parseInt(s.substring(idx, idx + i));
//                 if (ip <= 255) {
//                     nums[n] = ip;
//                     helper(s, idx + i, nums, n + 1);
//                 }
//             }
//         }
//     }
// }
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);

        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
}