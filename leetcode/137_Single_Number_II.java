// First time number appear -> save it in "ones"
// Second time -> clear "ones" but save it in "twos" for later check
// Third time -> try to save in "ones" but value saved in "twos" clear it.

class Solution {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}

class Solution {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;   // 第一轮， 记录是1的位， 出现了一次
            twos = (twos ^ A[i]) & ~ones;   // 第一轮， 记录是1的位，并且ones中不为1. 出现了二次
                                            // 然后第二轮， 第三轮
        }
        return ones;
    }
}

// https://discuss.leetcode.com/topic/22821/an-general-way-to-handle-all-this-sort-of-questions

// http://www.cnblogs.com/grandyang/p/4263927.html

// 还有一种解法，思路很相似，用3个整数来表示INT的各位的出现次数情况，one表示出现了1次，two表示出现了2次。当出现3次的时候该位清零。最后答案就是one的值。

// ones   代表第ith 位只出现一次的掩码变量
// twos  代表第ith 位只出现两次次的掩码变量
// threes  代表第ith 位只出现三次的掩码变量