// http://www.lintcode.com/en/problem/reverse-pairs/
// 用双栈结构解决问题， O(n^2), 这仅仅是暴利解法。
public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> help = new Stack<Integer>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
            // 如果栈顶大，那么计算大小
            } else if (stack.peek() > A[i]) {
                while (!stack.isEmpty() && stack.peek() > A[i]) {
                    help.push(stack.pop());
                    count++;
                }
                stack.push(A[i]);
                while (!help.isEmpty()) {
                    stack.push(help.pop());
                }
            // 如果栈顶不大，直接放入元素。
            } else {
                stack.push(A[i]);
            }
        }
        return count;
    }
}

// 运用merge sort的思想，O(n), 
public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }
    
    private int mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int sum = 0;
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid+1, end);
        sum += merge(A, start, mid, end);
        return sum;
    }
    
    private int merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[A.length];
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        int sum = 0;
        
        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
                sum += mid - leftIndex + 1;
            }
        }
        while (leftIndex <= mid) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        
        return sum;
    }
}