// https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
// 通过输入,来发现规律
// 123456789 10 11 12 13 14 15
// 123456789 1 2 3 4 5 6
public class Solution {
    public int addDigits(int num) {
        if (num == 0) 
            return 0;
        if (num % 9 == 0) 
            return 9;
        return num % 9;
    }
}

// best solution:
// return 1 + (num - 1) % 9;