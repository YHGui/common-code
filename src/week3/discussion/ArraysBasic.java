package week3.discussion;

/**
 * Created by Katsura on 2017/2/25.
 */
public class ArraysBasic {

    public static int[] insert (int[] x, int item, int position) {
        int length = x.length;
        int[] result = new int[length + 1];
        if (length <= position) {
            System.arraycopy(x, 0, result, 0, length);
            result[length] = item;
        }
        System.arraycopy(x, position, result, position + 1, length - position);
        System.arraycopy(x, 0, result, 0, position);
        result[position] = item;
        return result;
    }

    public static void reverse(int[] x) {
        int length = x.length;
        for (int i = 0; i < length / 2; i++) {
            swap(x, i, length - 1 - i);
        }
    }

    private static void swap(int[] x, int left, int right) {
        int temp = x[left];
        x[left] = x[right];
        x[right] = temp;
    }

    public static int[] xify(int[] x) {
        int total = 0;
        for (int element : x) {
            total += element;
        }
        int[] result = new int[total];
        int count = 0;
        for (int element : x) {
            for (int i = 0; i < element; i++) {
                result[count + i] = element;
            }
            count += element;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] x = new int[]{5, 9, 14, 15};
        printArray(x);
        System.out.println();

        int[] result = insert(x, 6, 2);
        printArray(result);
        System.out.println();

        reverse(x);
        printArray(x);
        System.out.println();

        result = xify(x);
        printArray(result);
        System.out.println();
    }

    private static void printArray(int[] x) {
        for (int element : x) {
            System.out.print(element + " ");
        }
    }
}
