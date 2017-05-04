// http://www.lintcode.com/en/problem/kth-largest-element/#
// http://www.jiuzhang.com/solutions/kth-largest-element/
// http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
// 另外可以用内置的sort 和 heap完成
// 快排思想, 快排有很多种实现方式，请认真分析边界条件。
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        return getKth(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    // 这是错误的方法，由于边界的限制，
    // public int getKth(int[] nums, int l, int r, int k) {
    //     if (l == r) {
    //         return nums[l];
    //     }
    //     int i = l;
    //     int j = r;
    //     int pivot = nums[l + (r - l) / 2];
    //     while (i < j) {
    //         while (nums[i] < pivot) {
    //             i++;
    //         }
    //         while (nums[j] >= pivot) {
    //             j--;
    //         }
    //         if (i == j) {
    //             break;
    //         }
    //         if (i < j) {
    //             swap(nums, i, j);
    //             i++;
    //             j--;
    //         }
    //     }
    //     if (i + 1 == k) {
    //         return pivot;
    //     } else if (i + 1 < k) {
    //         return getKth(nums, i + 1, r, k);
    //     } 
    //     return getKth(nums, l, i - 1, k);
    // }
    
    public int getKth(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int left = start;
        int right = end;
     
        while (true) {
            while (nums[left] < pivot && left < right) {
                left++;
            }
            // 注意！！ 这里有等于号，pivot一定在左指针右边,
            // 注意！！ 最后一步没有交换
            while (nums[right] >= pivot && right > left) {
                right--;
            }
            if (left == right) {
                break;
            }
            swap(nums, left, right);
        }
        // 注意！！ 
        swap(nums, left, end);
        
        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(nums, start, left - 1, k);
        } else {
            return getKth(nums, left + 1, end, k);
        }
    }
    
    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
};

// 九章算法的解法，最简洁。
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return getKth(nums, 0, nums.length - 1, nums.length - k + 1);
        
    }
    public int getKth(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return getKth(nums, position + 1, r, k);
        }  else {
            return getKth(nums, l, position - 1, k);
        }
    }
    public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];
        
        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;         
    }
};


