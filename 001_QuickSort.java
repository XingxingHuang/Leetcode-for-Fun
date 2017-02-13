public class QuickSortClass {
    public static void QuickSort(int[] array, int start, int end) {
        if(start<end)
        {
            int key = array[start];//初始化保存基元
            int i = start, j;//初始化i,j
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