// fast and slow loop to detect the cycle, similar to the linkedlist cycle detection
public class Solution {
    public int getSum(int n){
        int outSum = 0;
        while (n != 0) {
            outSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return outSum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
        } while (fast != slow);
        if (fast == 1) {
            return true;
        }
        return false;
    }
}

// using hashset
public boolean isHappy(int n) {
    Set<Integer> inLoop = new HashSet<Integer>();
    int squareSum,remain;
    while (inLoop.add(n)) {
        squareSum = 0;
        while (n > 0) {
            remain = n%10;
            squareSum += remain*remain;
            n /= 10;
        }
        if (squareSum == 1)
            return true;
        else
            n = squareSum;

    }
    return false;

}