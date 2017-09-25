// Socyrus
// brute force. Needn't consider the (), just use permutations of nums.
class Solution {
    char[] ops = new char[]{'+', '-', '*', '/'};
    
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num: nums)
            list.add(1.0 * num);
        
        return search(list);
    }
    
    private boolean search(List<Double> list){
        if (list.size() == 1)
            return list.get(0)==24.0;
        
        List<Double> tmp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                for (char op: ops){
                    if ((op == '+' || op == '*') && (i > j)) continue;
                    if (op == '/' && list.get(j) == 0.0) continue;
                    double res = 0.0;
                    switch(op) {
                        case '+': res = list.get(i) + list.get(j);
                                  break;
                        case '-': res = list.get(i) - list.get(j);
                                  break;
                        case '*': res = list.get(i) * list.get(j);
                                  break;
                        case '/': res = list.get(i) / list.get(j);
                                  break;
                    }

                    tmp.clear();
                    tmp.add(res);
                    for (int k = 0; k < list.size(); k++)
                        if (k != i && k != j)
                            tmp.add(list.get(k));

                    boolean tmpRes = search(tmp);
                    if (tmpRes) return true;
                }
            }
        }
        return false;
    }
}


// Solution: 
// https://leetcode.com/problems/24-game/solution/
class Solution {
    public boolean judgePoint24(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        for (int v: nums) A.add((double) v);
        return solve(A);
    }
    // check whether nums can be calculated to be 24, size can be differnt.
    private boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) return false;
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<Double>();
                    for (int k = 0; k < nums.size(); k++) if (k != i && k != j) {
                        nums2.add(nums.get(k));
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue; // k < 2的时候，i和j的order没关系，所以可以跳过节省时间
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j)); // +
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j)); // *
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j)); // -
                        if (k == 3) { // 除法
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
