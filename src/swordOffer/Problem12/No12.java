package swordOffer.Problem12;

public class No12 {
    public static void main(String[] args) {
        printOneToNthDigits(2);
    }


    private static void printOneToNthDigits(int n) {
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }

        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * 递归法打印
     * @param n
     * @param arr
     */
    private static void printOneToNthDigits(int n, int[] arr) {

        if (n >= arr.length) {
            printArray(arr);
        } else {
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    /**
     * 打印数组，需要注意的是从非零开始打印
     * @param arr
     */
    private static void printArray(int[] arr) {

        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index += 1;
        }

        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        if (index < arr.length) {
            System.out.println();
        }
    }
}
