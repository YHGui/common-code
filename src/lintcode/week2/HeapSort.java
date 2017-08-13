package lintcode.week2;

/**
 * Created by Katsura on 2017/3/20.
 */
public class HeapSort {
    //对100亿条数据选择Top k数据，只能用堆排序，只需维护一个k大小的空间
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            //修复heap
            heapAdjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            //将最后一个元素与最大堆的顶端交换,堆的大小会随着越来越小
            swap(arr, 0, i);
            //交换之后，重现修复maxHeap
            heapAdjust(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void heapAdjust(int[] arr, int i, int length) {
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < length; i = child) {
            child = leftChild(i);
            if (child != length - 1 && arr[child] > arr[child + 1]) {
                child++;
            }
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break;
            }
        }
        arr[i] = father;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }
}
