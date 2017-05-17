// sift up
void siftup (int id) {
    while (parent(id) > -1) {
        int parentId = parent(id);
        if (comparesmall(heap.get(parentId), heap.get(id)) == true) {
            break;
        } else {
            swap(id, parentId);
        }
        id = parentId;
    }
}

//Sift Down 
void siftdown (int id) {
    while (lson(id) < heap.size()) {
        int leftId = lson(id);
        int rightId = rson(id);
        int son;
        if (rightId >= heap.size() ||
                (comparesmall(heap.get(leftId), heap.get(rightId)) == true)) {
            son = leftId;
        } else {
            son = rightId;
        }
        if (comparesmall(heap.get(id), heap.get(son)) == true) {
            break;
        } else {
            swap(id, son);
        }
        id = son;
    }
}

// 完整heapify代码 ： http://www.jiuzhang.com/solutions/heapify/

// Version Linpz
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    private void siftdown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2])
                son = k * 2 + 2;
            if (A[son] >= A[k])
                break;
            
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }
    
    public void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
}

// Version 1: this cost O(n)
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    private void siftdown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            if (smallest == k) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;
            
            k = smallest;
        }
    }
    
    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        } // for
    }
}


// Version 2: This cost O(nlogn)
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    private void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) / 2;
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;
            
            k = father;
        }
    }
    
    public void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }
}