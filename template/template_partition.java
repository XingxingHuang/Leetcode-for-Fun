// Partition类
//   Partition-array
//   Sort Colors
//   Partition Array by Odd and Even 
//   Sort Letters by Case
//   Valid Palindrome
//   quick sort/ quick select/ nuts bolts problem/wiggle sort II

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
            left++''
        }
        nums[right] = nums[left];
    }
    
    // 返还pivot点到数组里面
    nums[pivot] = pivot;
    return left;
}