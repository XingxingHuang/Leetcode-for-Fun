/**
 * Two sum 模板
 * 这一类通过对撞型指针优化算法，根本上其实要证明就是不用扫描多余状态
 * 算法复杂度下降到 O(n)
 * 相会型指针的题目：
 *     2 sum 
 *     3 sum closest
 *     3 sum
 *     4 sum
 *     Two sum II
 *     Triangle Count
 *     Trapping Rain Water
 *     Container With Most Water
 */

int left = 0, right = nums.length - 1;
while (left < right) {
    if (A[left] 和 A[right] 满足某一条件) {
        //做一些事情
        right--; // 不用考虑[left + 1, right - 1] 和 right组成的pair；
    } else if (A[left] 和 A[right] 不满足某一条件) {
        left++; // 不用考虑[left + 1, right - 1] 和 left 组成的pair
    }
}

