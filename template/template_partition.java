// Partition类
//   Partition-array
//   Sort Colors
//   Partition Array by Odd and Even 
//   Sort Letters by Case
//   Valid Palindrome
//   quick sort/ quick select/ nuts bolts problem/wiggle sort II

// two slides about partition 
// http://algs4.cs.princeton.edu/lectures/23DemoPartitioning.pdf
// https://www.cs.princeton.edu/~rs/talks/QuicksortIsOptimal.pdf

public int partition (int[] nums, int l, int r) {
    // 初始化左右指针和pivot
    int left = l;
    int right = r;
    int pivot = nums[left];
    
    // 进行partition
    while (left < right) {
        while (left < right && nums[right] >= pivot) {
            right--;
        }
        nums[left] = nums[right];
        while (left < right && nums[left] <= privot) {
            left++;
        }
        nums[right] = nums[left];
    }
    
    // 返还pivot点到数组里面
    nums[left] = pivot;
    // 继续partition
    return left;
}

// three way partition
// https://en.wikipedia.org/wiki/Dutch_national_flag_problem#Pseudocode
procedure three-way-partition(A : array of values, mid : value):
    i ← 0
    j ← 0
    n ← size of A - 1

    while j ≤ n:
        if A[j] < mid:
            swap A[i] and A[j]
            i ← i + 1
            j ← j + 1
        else if A[j] > mid:
            swap A[j] and A[n]
            n ← n - 1
        else:
            j ← j + 1