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