public class MyQuickSort {
     
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
         
        MyQuickSort sorter = new MyQuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sorter.sort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}


public class QuickSortClass {
    public static void QuickSort(int[] array, int start, int end) {
        if(start<end) {
            int key = array[start];//初始化保存基元
            int i = start;
            int j = end;//初始化i,j
            for(j = start + 1; j <= end; j++) {
                if(array[j] < key) {//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                    int temp = array[j];
                    array[j] = array[i + 1];
                    array[i + 1] = temp;
                    i++;
                }
            }
            array[start] = array[i];//交换i处元素和基元
            array[i] = key;
            QuickSort(array, start, i - 1);//递归调用
            QuickSort(array, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {11, 213, 134, 44, 77, 78, 23, 43};
        QuickSort(array, 0, array.length - 1);
        for(int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + "th:" + array[i]);
        }
    }
}


