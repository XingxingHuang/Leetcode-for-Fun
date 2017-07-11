// 注意分析与背包问题的相关性和区别。
// Complexity Analysis

// Time complexity : O(2^n). 
//      For every offer we are considering two options, offer taken and offer not taken. Here n is the length of the special list.
// Space complexity : O(n)O(n). Recursion stack can go up to size n.

public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }
    
    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int i) {
        // 递归终止条件，到达offer的数组大小
        if (i == special.size())
            return dot(needs, price);
        ArrayList<Integer> clone = new ArrayList<>(needs);
        int j = 0;
        for (j = 0; j < special.get(i).size() - 1; j++) {
            int diff = clone.get(j) - special.get(i).get(j);
            if (diff < 0)
                break;
            clone.set(j, diff);
        }
        if (j == special.get(i).size() - 1)
            return Math.min(special.get(i).get(j) + shopping(price, special, clone, i), shopping(price, special, needs, i + 1));
        else
            return shopping(price, special, needs, i + 1);
    }
    
    public int dot(List<Integer> a, List<Integer> b) {
        // 两数组点乘，输入为needs，price数组
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
}


public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> dp = new HashMap<>();
        List<Integer> allZero = new ArrayList<>();
        for(int i=0;i<needs.size();i++) {
            allZero.add(0);
        }
        dp.put(allZero, 0);
        return dfs(needs, price, special, dp);
    }
    private int dfs(List<Integer> needs, List<Integer> price, List<List<Integer>> special, Map<List<Integer>, Integer> dp) {
        if(dp.containsKey(needs)) return dp.get(needs);
        int res = Integer.MAX_VALUE;
        for(List<Integer> s : special) {
            List<Integer> needsCopy = new ArrayList<>(needs);
            boolean valid = true;
            for(int i=0;i<needs.size();i++) {
                needsCopy.set(i, needsCopy.get(i) - s.get(i));
                if(needsCopy.get(i) < 0) {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                res = Math.min(res, s.get(needs.size()) + dfs(needsCopy, price, special, dp));
            }
        }
        //What if we do not use specials? specials can be deceiving,
        //perhaps buying using regular prices is cheaper.
        int noSpecial = 0;
            for(int i=0;i<needs.size();i++) {
                noSpecial += needs.get(i) * price.get(i);
            }
        res = Math.min(res, noSpecial);    

        dp.put(needs, res);
        return res;
    }
}