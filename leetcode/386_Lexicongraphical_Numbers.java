// 2017.08.21 Xingxing Huang
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) 
            return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int m = stack.pop();
            int limit = 1;
            if (m != 0) {
                res.add(m);
                limit = 0;
            }
            for (int i = 9; i >= limit; i--) { // m = 0 时取1， 其余取0
                if (m * 10 + i <= n) {
                    stack.push(m * 10 + i);
                }
            }
        }
        return res;
    }
}

// 递归方法
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) 
            return res;
        add(res, 0, n);
        return res;
    }
    private void add(List<Integer> res, int m, int n) {
        if (m > n) 
            return;
        if (m != 0) {
            res.add(m);
            for (int i = 0; i <= 9; i++) 
                add(res, m * 10 + i, n);
            
        } else {
            for (int i = 1; i <= 9; i++)
                add(res, m * 10 + i, n);
        }
    }
}


// O(n) time O(1) space
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}